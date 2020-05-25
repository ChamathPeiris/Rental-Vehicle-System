package Phase1;

public class Car extends Vehicle {
    private int numOfAirbags;
    private int getNumOfSeats;
    //proper attributes arent used in the car class
    public Car() {
        super();
    }

    public Car(int vehicleId, String plateNumber, String make, String model, int engineCapacity, double rate, String isAvailable, int numOfAirbags, int getNumOfSeats) {
        super(vehicleId, plateNumber, make, model, engineCapacity, rate,isAvailable);
        this.numOfAirbags = numOfAirbags;
        this.getNumOfSeats = getNumOfSeats;
    }



    public int getNumOfAirbags() {
        return numOfAirbags;
    }

    public void setNumOfAirbags(int numOfAirbags) {
        this.numOfAirbags = numOfAirbags;
    }

    public int getGetNumOfSeats() {
        return getNumOfSeats;
    }

    public void setGetNumOfSeats(int getNumOfSeats) {
        this.getNumOfSeats = getNumOfSeats;
    }

    @Override
    public String toString() {
        return "Car{"+super.toString() + "numOfAirbags=" + numOfAirbags + ", getNumOfSeats=" + getNumOfSeats + '}';
    }
}
