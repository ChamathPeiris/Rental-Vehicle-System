package lk.chamath.CourseWork3.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter

@Document(collection ="customer")
public class Customer {
    private int cusId;
    private String cusName;
    private String cusPhoneNb;
    private String cusEmail;
    private String licenseNumber;
    private int vehicleID;
    private String pickUpDate;
    private String dropOffDate;

    public Customer(int cusId, String cusName, String cusPhoneNb, String cusEmail, String licenseNumber, String pickUpDate, String dropOffDate, int vehicleID) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusPhoneNb = cusPhoneNb;
        this.cusEmail = cusEmail;
        this.licenseNumber = licenseNumber;
        this.pickUpDate = pickUpDate;
        this.vehicleID = vehicleID;
        this.dropOffDate = dropOffDate;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhoneNb() {
        return cusPhoneNb;
    }

    public void setCusPhoneNb(String cusPhoneNb) {
        this.cusPhoneNb = cusPhoneNb;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusPhoneNb='" + cusPhoneNb + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", vehicleID=" + vehicleID +
                ", pickUpDate='" + pickUpDate + '\'' +
                ", dropOffDate='" + dropOffDate + '\'' +
                '}';
    }
}

