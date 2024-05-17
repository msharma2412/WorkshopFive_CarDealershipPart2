package com.ps;

public class LeaseContract extends Contract {

    private double expectedEndingValue;

    private double leaseFee;

    public LeaseContract(){

    }

    public LeaseContract(double expectedEndingValue,double leaseFee){

    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {

        return vehicleSold.getPrice() * 0.07;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double monthlyPayment() {

        double interest = vehicleSold.getPrice() * 0.04;
        double carTotal = vehicleSold.getPrice() + interest;

        return (carTotal/36);
    }

    @Override
    public double getTotalPrice() {
        double interest = vehicleSold.getPrice() * 0.04;


        // ask instructor whether we are n the right path
        return vehicleSold.getPrice() + interest;
    }
}
// instance of is an operator