package lk.chamath.CourseWork3.models;

public class Vehicle {

    private int vehicleId;
    private String plateNumber;
    private String make;
    private String model;
    private int engineCapacity;
    private Double rate;
    private String isAvailable;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, String plateNumber, String make, String model, int engineCapacity, Double rate, String isAvailable) {
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.rate = rate;
        this.isAvailable=isAvailable;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String isAvailable() {
        return isAvailable;
    }

    public void setAvailable(String available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", rate=" + rate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
