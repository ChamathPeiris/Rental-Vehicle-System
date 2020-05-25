package lk.chamath.CourseWork3.models;

public class Car extends Vehicle {
    private int numOfAirbags;
    private int numOfSeats;

    public Car() {
        super();
    }

    public Car(int vehicleId, String plateNumber, String make, String model, int engineCapacity, Double rate, String isAvailable, int numOfAirbags, int numOfSeats) {
        super(vehicleId, plateNumber, make, model, engineCapacity, rate,isAvailable);
        this.numOfAirbags = numOfAirbags;
        this.numOfSeats = numOfSeats;
    }



    public int getNumOfAirbags() {
        return numOfAirbags;
    }

    public void setNumOfAirbags(int numOfAirbags) {
        this.numOfAirbags = numOfAirbags;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    @Override
    public String toString() {
        return "Car{"+super.toString() + "numOfAirbags=" + numOfAirbags + ", numOfSeats=" + numOfSeats + '}';
    }
}
