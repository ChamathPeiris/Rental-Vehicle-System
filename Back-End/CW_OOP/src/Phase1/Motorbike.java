package Phase1;

public class Motorbike extends Vehicle {
    private String luggage;//boolean variable
    private String startingType;//enum

    public Motorbike() {
        super();
    }

    public Motorbike(int vehicleId, String plateNumber, String make, String model, int engineCapacity, double rate, String isAvailable, String luggage, String startingType) {
        super(vehicleId, plateNumber, make, model, engineCapacity, rate,isAvailable);
        this.luggage = luggage;
        this.startingType = startingType;
    }

    public String isLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getStartingType() {
        return startingType;
    }

    public void setStartingType(String startingType) {
        this.startingType = startingType;
    }

    @Override
    public String toString() {
        return "Motorbike{" +super.toString()+ "luggage=" + luggage + ", startingType='" + startingType + '\'' + '}';
    }
}
