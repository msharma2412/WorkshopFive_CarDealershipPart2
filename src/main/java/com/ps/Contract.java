package com.ps;

public abstract class Contract {
    protected String dateOfContract;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicleSold;
//    protected double totalPrice;
  //  protected double monthlyPayment;

    public Contract(){

    }

    public Contract(Vehicle vehicleSold, String customerEmail, String customerName, String dateOfContract) {
        this.vehicleSold = vehicleSold;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.dateOfContract = dateOfContract;

    }
    //

    // look up difference bt private and proteted

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }


    //an abstract method is a method without implementation logic.

    public abstract double monthlyPayment();
// payment per montH  would be 12 payments a  year

    //  double monthlyPayment = monthlyPayment() / 12 / 100;

    public abstract double getTotalPrice();

//need to figure out what overriding is and how to make an abstract mehtod that calculate it

}

