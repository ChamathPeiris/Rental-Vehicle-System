package Phase1;

public class Customer {
    private int cusId;
    private String cusName;
    private String cusPhoneNb;
    private String cusEmail;
    private String licenseNumber;
    private Date pickUpDate;
    private Date dropOffDate;

    public Customer(int cusId, String cusName, String cusPhoneNb, String cusEmail,String licenseNumber, Date pickUpDate, Date dropOffDate) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusPhoneNb = cusPhoneNb;
        this.cusEmail= cusEmail;
        this.licenseNumber = licenseNumber;
        this.pickUpDate = pickUpDate;
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

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusPhoneNb='" + cusPhoneNb + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}

