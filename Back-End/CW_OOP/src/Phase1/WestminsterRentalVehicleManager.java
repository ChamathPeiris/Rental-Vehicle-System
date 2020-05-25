package Phase1;

import com.mongodb.Cursor;
import com.mongodb.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class WestminsterRentalVehicleManager implements RentalVehicleManger {

    //Vehicle object ArrayList
    private ArrayList<Vehicle> vehicleList;
    public static final int numObject = 50;

    public WestminsterRentalVehicleManager(int listLength) {
        vehicleList = new ArrayList<Vehicle>();
    }


    // code to create the connection
    private MongoClient mongoClient = new MongoClient("localhost", 27017);

    // code to connect to the database
    private DB database = mongoClient.getDB("westminsterRentalVehicleSystem");

    private Scanner sc = new Scanner(System.in);




    @Override
    public void addVehicle(Vehicle vehicle, DBObject document) {
        //checks whether the size of array increase the maximum level
        if (vehicleList.size() < numObject) {
            vehicleList.add(vehicle);
            System.out.println(vehicleList.size());
    }else

    {
        System.out.println("No more space in the List");
    }
}

    @Override
    public void deleteVehicle(String vehicleType) {
        //Get the type of the vehicle
        DBCollection collection = database.getCollection(vehicleType);
        BasicDBObject document = new BasicDBObject();
        System.out.println("Enter the vehicle Id: ");
        //get the Id of the Car
        int vehicleId = sc.nextInt();
        document.put("vehicleId", vehicleId);
        //remove from the collection
        collection.remove(document);


        //Get the type of the Vehicle
        DBCollection collection1 = database.getCollection(vehicleType);
        BasicDBObject document1 = new BasicDBObject();
        System.out.println("Enter the vehicle Id: ");
        //get the Id of the motorbike
        document1.put("vehicleId", vehicleId);
        //remove from the collection
        collection1.remove(document1);
    }
    @Override
    public void editVehicle(String vehicleType) {
        DBCollection collection = database.getCollection(vehicleType);
        System.out.println("Enter the Vehicle Id: ");
        int vehicleId = sc.nextInt();
        BasicDBObject searchQuery = new BasicDBObject().append("vehicleId", vehicleId);
        BasicDBObject updateQuery = new BasicDBObject();
        BasicDBObject newDocument = new BasicDBObject();

        //update the plate number
        System.out.println("Enter the Plate Number: ");
        String plateNb = sc.next();
        updateQuery.append("plateNb", plateNb);

        //update the make of the vehicle
        System.out.println("Enter the Make: ");
        String make = sc.next();
        updateQuery.append("make", make);

        //update the model of the vehicle
        System.out.println("Enter the Model: ");
        String model = sc.next();
        updateQuery.append("model", model);

        //update the engine capacity of the vehicle
        System.out.println("Enter the Engine Capacity: ");
        int engineCapacity = sc.nextInt();
        updateQuery.append("engineCapacity", engineCapacity);

        //update the rate of the vehicle
        System.out.println("Enter the Vehicle Rate: ");
        double rate = sc.nextDouble();
        updateQuery.append("rate", rate);


        //update the list
        newDocument.append("$set", updateQuery);
        collection.update(searchQuery, newDocument);

    }

    @Override
    public void printList() {
        //date whether print the list
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(dateTimeFormatter.format(localDateTime));

        //print the car list
        System.out.println("Car List");
        DBCollection collection = database.getCollection("car");
        //sort according to the make of the car
        Cursor cursor = collection.find().sort(new BasicDBObject("make",1));
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
            System.out.println();
     }
        //print the vehicle list
        System.out.println("Motorbike List");
        DBCollection collection1 = database.getCollection("motorBike");
        //sort according to the make of the motorbike
        Cursor cursor1 = collection1.find().sort(new BasicDBObject("make",1));
        while(cursor1.hasNext()) {
            System.out.println(cursor1.next());
            System.out.println();
        }

    }

    @Override
    public void saveFile() {
        //create collection objects
        DBCollection collection = database.getCollection("car");
        DBCollection collection1 = database.getCollection("motorBike");
        Cursor cursor = (Cursor) collection.find().iterator();
        Cursor cursor1 = (Cursor) collection1.find().iterator();

        //File saved path
        String path = "C:/Users/Acer/IdeaProjects/CW_OOP/Vehicle-List.txt";

        FileOutputStream    outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Save date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(dateTimeFormatter.format(localDateTime));

        //Print to the list
        System.out.println("Car List");
        System.out.println();
        while (cursor.hasNext()) {
            byte[] cars = cursor.next().toString().getBytes();
            try {
                outputStream.write(cars);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            System.out.println("Motorbike List ");
            System.out.println();
            while (cursor1.hasNext()) {
                byte[] bikes = cursor1.next().toString().getBytes();
                try {
                    outputStream.write(bikes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println("Data Saved to the file");

        }



    @Override
    public boolean runMenu() {

        //Create the objects
        Car car = new Car();
        Motorbike motorbike = new Motorbike();

        boolean exit = false;
        System.out.println("****** Welcome to Westminster Rental Vehicle System *******");
        System.out.println("Press 1 to Manager LogIn");
        System.out.println("Press 2 to Customer LogIn");
        System.out.println("Press 3 to exit the program");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Press 1 if you want to add a Vehicle");
                System.out.println("Press 2 if you want to delete a Vehicle");
                System.out.println("Press 3 if you want to edit a Vehicle");
                System.out.println("Press 4 if you want to view Vehicle List");
                System.out.println("Press 5 if you want to view the File");
                int choice2 = s.nextInt();
                s.nextLine();
                switch (choice2) {
                    case 1:
                        System.out.println("Press 1 if you want to add a car");
                        System.out.println("Press 2 if you want to add a motorbike");
                        int choice3 = s.nextInt();
                            switch (choice3) {

                                case 1:

                                    DBObject document = new BasicDBObject();
                                    DBCollection collection = database.getCollection("car");

                                    //get the vehicle id
                                    int vehicleId;
                                    while (true) {
                                        try {
                                            //check whether the valid vehicle Id
                                            System.out.println("Enter the Vehicle Id: ");
                                            vehicleId = sc.nextInt();
                                            car.setVehicleId(vehicleId);
                                            document.put("vehicleId", car.getVehicleId());
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Please enter a valid input");
                                            sc.nextLine();
                                        }
                                    }

                                    //Get the plate number
                                    System.out.println("Enter the Vehicle Plate Number: ");
                                    String plateNumber = sc.next();
                                    car.setPlateNumber(plateNumber);
                                    document.put("plateNb", car.getPlateNumber());

                                    //Get the make if the vehicle
                                    System.out.println("Enter the Vehicle Make: ");
                                    String make = sc.next();
                                    car.setMake(make);
                                    document.put("make", car.getMake());

                                    //get the model of the vehicle
                                    System.out.println("Enter the Vehicle Model: ");
                                    String model = sc.next();
                                    car.setModel(model);
                                    document.put("model", car.getModel());

                                    //Get the engine capacity of the vehicle
                                    int engineCapacity;
                                    while (true) {
                                        try {
                                            //check whether the valid input
                                            System.out.println("Enter the Vehicle Engine Capacity: ");
                                            engineCapacity = sc.nextInt();
                                            car.setEngineCapacity(engineCapacity);
                                            document.put("engineCapacity", car.getEngineCapacity());
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Please enter a valid input");
                                            sc.nextLine();
                                        }
                                    }

                                    //Get the rate of the vehicle
                                    double rate;
                                    while (true) {
                                        try {
                                            //check whether the valid input
                                            System.out.println("Enter the Vehicle Rate: ");
                                            rate = sc.nextDouble();
                                            car.setRate(rate);
                                            document.put("rate", car.getRate());
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Please enter a valid input");
                                            sc.nextLine();
                                        }
                                    }

                                    //Get the availability status
                                    System.out.println("Is this vehicle available: ");
                                    String isAvailable = sc.next();
                                    car.setAvailable(isAvailable);
                                    document.put("isAvailable", car.isAvailable());


                                    //get the number of air bags
                                    int numOfAirbags ;
                                    while (true) {
                                        try {
                                            //check whether the valid input
                                            System.out.println("Enter the number of air bags: ");
                                            numOfAirbags = sc.nextInt();
                                            car.setNumOfAirbags(numOfAirbags);
                                            document.put("numOfAirbags", car.getNumOfAirbags());
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Please enter a valid input");
                                            sc.nextLine();
                                        }
                                    }

                                    //Get the number of seats
                                    int numOfSeats;
                                    while (true) {
                                        try {
                                            //check whether the valid input
                                            System.out.println("Enter the number of seats: ");
                                            numOfSeats = sc.nextInt();
                                            car.setGetNumOfSeats(numOfSeats);
                                            document.put("numOfSeats", car.getGetNumOfSeats());
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Please enter a valid input");
                                            sc.nextLine();
                                        }

                                    }

                                    //Assign data to the object
                                    Vehicle vehicle = new Car(vehicleId, plateNumber, make, model, engineCapacity, rate, isAvailable, numOfAirbags, numOfSeats);
                                    //insert to the database
                                    collection.insert(document);

                                    //call addVehicle() method
                                    this.addVehicle(vehicle, document);
                                    break;

                                case 2:

                                    DBObject document1 = new BasicDBObject();
                                    DBCollection collection1 = database.getCollection("motorBike");


                                    int vehicleId1;
                                    while (true) {
                                        try {
                                            System.out.println("Enter the Vehicle Id: ");
                                            vehicleId1 = sc.nextInt();
                                            motorbike.setVehicleId(vehicleId1);
                                            document1.put("vehicleId", motorbike.getVehicleId());
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Please enter a valid input");
                                            sc.nextLine();
                                        }
                                    }



                                    System.out.println("Enter the Vehicle Plate Number: ");
                                    String plateNumber1 = sc.next();
                                    motorbike.setPlateNumber(plateNumber1);
                                    document1.put("plateNb", motorbike.getPlateNumber());

                                    System.out.println("Enter the Vehicle Make: ");
                                    String make1 = sc.next();
                                    motorbike.setMake(make1);
                                    document1.put("make", motorbike.getMake());

                                    System.out.println("Enter the Vehicle Model: ");
                                    String model1 = sc.next();
                                    motorbike.setModel(model1);
                                    document1.put("model", motorbike.getModel());

                                    int engineCapacity1;
                                    while (true) {
                                        try {
                                            System.out.println("Enter the Vehicle Engine Capacity: ");
                                            engineCapacity1 = sc.nextInt();
                                            motorbike.setEngineCapacity(engineCapacity1);
                                            document1.put("engineCapacity", motorbike.getEngineCapacity());
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Please enter a valid input");
                                            sc.nextLine();
                                        }
                                    }

                                    double rate1;
                                    while (true) {
                                        try {
                                            System.out.println("Enter the Vehicle Rate: ");
                                            rate1 = sc.nextDouble();
                                            motorbike.setRate(rate1);
                                            document1.put("rate", motorbike.getRate());
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Please enter a valid input");
                                            sc.nextLine();
                                        }
                                    }

                                    System.out.println("Is this vehicle available: ");
                                    String isAvailable1 = sc.next();
                                    motorbike.setAvailable(isAvailable1);
                                    document1.put("isAvailable", motorbike.isAvailable());

                                    System.out.println("Is there any luggage: ");
                                    String luggage1 = sc.next();
                                    motorbike.setLuggage(luggage1);
                                    document1.put("luggage", motorbike.isLuggage());

                                    System.out.println("Starting type: ");
                                    String startingType1 = sc.next();
                                    motorbike.setStartingType(startingType1);
                                    document1.put("startingType", motorbike.getStartingType());

                                    Vehicle vehicle1 = new Motorbike(vehicleId1, plateNumber1, make1, model1, engineCapacity1, rate1, isAvailable1, luggage1, startingType1);
                                    collection1.insert(document1);
                                    this.addVehicle(vehicle1, document1);

                                    break;
                            }
                                break;
                                case 2:
                                    System.out.println("Enter the Vehicle Type: ");
                                    String vehicleType = sc.next();
                                    this.deleteVehicle(vehicleType);
                                    break;
                                case 3:
                                    System.out.println("Enter the Vehicle Type: ");
                                    String editVehicleType = sc.next();
                                    this.editVehicle(editVehicleType);
                                    break;
                                case 4:
                                    this.printList();
                                    break;
                                case 5:
                                    this.saveFile();
                                    break;
                        }
                        break;
                    case 2:
                        //Open url http://localhost:4200, which is the Angular interface for the customer
                        try {
                            URI uri = new URI("http://localhost:4200");
                            Desktop desktop = null;
                            if (Desktop.isDesktopSupported()) {
                                desktop = Desktop.getDesktop();
                            }

                            if (desktop != null)
                                desktop.browse(uri);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        } catch (URISyntaxException use) {
                            use.printStackTrace();
                        }


                        break;
                    case 3:
                        exit = true;
                        break;
                }
                return exit;
        }


        public static void main (String[]args){

        //disable mongodb java driver log in
            final LogManager lm = LogManager.getLogManager();
            for(final Enumeration<String> i = lm.getLoggerNames(); i.hasMoreElements(); ) {
                lm.getLogger( i.nextElement()).setLevel( Level.OFF );
            }


            RentalVehicleManger sys = new WestminsterRentalVehicleManager(50);
            boolean exit = false;
            while (!exit) {
                exit = sys.runMenu();
            }
        }
}