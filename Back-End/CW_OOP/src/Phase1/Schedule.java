package Phase1;

public class Schedule {
        private  int scheduleId;
        private Date pickUpDate;
        private Date dropOffDate;
        private Vehicle vehicleId;
        private Customer cusId;

    public Schedule(int scheduleId, Date pickUpDate, Date dropOffDate, Customer cusId) {
        this.scheduleId = scheduleId;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.cusId = cusId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Customer getCusId() {
        return cusId;
    }

    public void setCusId(Customer cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Schedule{" + "scheduleId=" + scheduleId + ", pickUpDate=" + pickUpDate + ", dropOffDate=" + dropOffDate + ", vehicleId=" + vehicleId + ", cusId=" + cusId + '}';
    }
}
