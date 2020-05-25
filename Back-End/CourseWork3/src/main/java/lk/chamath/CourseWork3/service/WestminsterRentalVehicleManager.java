package lk.chamath.CourseWork3.service;

import com.mongodb.*;
import lk.chamath.CourseWork3.Repository.CustomerRepository;
import lk.chamath.CourseWork3.models.Car;
import lk.chamath.CourseWork3.models.Customer;
import lk.chamath.CourseWork3.models.Motorbike;
import lk.chamath.CourseWork3.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;


@Service
public class WestminsterRentalVehicleManager implements RentalVehicleManger {


    // code to create the connection
    private MongoClient mongoClient = new MongoClient("localhost", 27017);

    // code to connect to the database
    private DB database = mongoClient.getDB("westminsterRentalVehicleSystem");
    @Autowired
    private CustomerRepository customerRepository;

    //Get car list from the database
    public List<Car> getAllCars(){
        DBCollection cars = database.getCollection("car");
        ArrayList<Car> carsArray = new ArrayList<>();
        for(DBObject record : cars.find()){
            Car car = new Car(
                    (int)record.get("vehicleId"),
                    (String)record.get("plateNb"),
                    (String)record.get("make"),
                    (String)record.get("model"),
                    (int)record.get("engineCapacity"),
                    (Double) record.get("rate"),
                    (String)record.get("isAvailable"),
                    (int)record.get("numOfAirbags"),
                    (int)record.get("numOfSeats"));
            carsArray.add(car);
        }
        return carsArray;
    }

    //Get motorbike list from the database
    public List<Motorbike> getAllMotorBikes(){
        DBCollection motorbikes = database.getCollection("motorBike");
        ArrayList<Motorbike> motorbikesArray = new ArrayList<>();
        for(DBObject record : motorbikes.find()){
            Motorbike motorbike = new Motorbike(
                    (int)record.get("vehicleId"),
                    (String)record.get("plateNb"),
                    (String)record.get("make"),
                    (String)record.get("model"),
                    (int)record.get("engineCapacity"),
                    (Double) record.get("rate"),
                    (String)record.get("isAvailable"),
                    (String) record.get("luggage"),
                    (String) record.get("startingType"));
            motorbikesArray.add(motorbike);
        }
        return motorbikesArray;
    }

    //Get the customer details from the database
public List<Customer> getCustomer(){
    DBCollection customers = database.getCollection("customer");
    ArrayList<Customer> customerArray = new ArrayList<>();
    for(DBObject record : customers.find()){
        Customer customer = new Customer(
                (int)record.get("cusId"),
                (String)record.get("cusName"),
                (String)record.get("cusPhoneNb"),
                (String)record.get("cusEmail"),
                (String)record.get("licenseNumber"),
                (String)record.get("pickUpDate"),
                (String)record.get("dropOffDate"),
                (int)record.get("vehicleID"));
        customerArray.add(customer);
        }
        return customerArray;
    }

    public Map<String, String> filterByVehicle(int vehicleID, Date pickup, Date dropoff){
        List<Customer> customerList= getCustomer();
        List<Customer> customers= new ArrayList<Customer>();
        List<Date> checkDates = getDatesBetween(pickup, dropoff);
        for (Customer customer:customerList
             ) {
            if(vehicleID==customer.getVehicleID()){
                customers.add(customer);
            }
        }
        if(customers.isEmpty()){
            return Collections.singletonMap("status", "available");
        }else{
            for (Customer cus :
                    customers) {
               List<Date> dates =  getDatesBetween(Date.valueOf(cus.getPickUpDate()),Date.valueOf(cus.getDropOffDate()));
               dates.retainAll(checkDates);
               if(!dates.isEmpty()){
                   return Collections.singletonMap("status", "unavailable");

               }
            }
            return Collections.singletonMap("status", "available");

        }
    }

    public  List<Date> getDatesBetween(
            Date startDate, Date endDate) {

        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);

        while (calendar.before(endCalendar)) {
            java.util.Date result = calendar.getTime();
            java.sql.Date sqlDate = new java.sql.Date(result.getTime());
            datesInRange.add(sqlDate);
            calendar.add(Calendar.DATE, 1);
        }

        java.sql.Date sqlDate = new java.sql.Date(endDate.getTime());
        datesInRange.add(sqlDate);
        calendar.add(Calendar.DATE, 1);

        return datesInRange;
    }
//    public Customer findOne(int vehicleId) {
//        Customer customer = dbOperations.getMongoOpertion().findOne(Query.query(.where("vehicleID").is(vehicleId)),
//                Customer.class, "customer");
//        return customer;
//    }



   @Override
    public void addVehicle(Vehicle vehicle, DBObject document) {

    }

    @Override
    public void deleteVehicle(String vehicleType) {

    }

    @Override
    public void editVehicle(String vehicleType) {

    }

    @Override
    public void printList() {

    }

    @Override
    public void saveFile() {

    }

    @Override
    public boolean runMenu() {
        return false;
    }
}