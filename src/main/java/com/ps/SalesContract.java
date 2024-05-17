package com.ps;

public class SalesContract extends Contract {
//int vehiclePrice =10_000;
//boolean buyerFinance = true;
//boolean buyerWillnotFinance=false;

    private double saleTaxAmount;
    private static int recordingFee = 100;
    private double processingFee;
    private boolean finance;


//salescontract.vehcile.price.
    public SalesContract(double saleTaxAmount, double processingFee) {
        this.saleTaxAmount = saleTaxAmount;
        this.processingFee = processingFee;

    }

    public SalesContract() {
    }

    public double getSalexTaxAmount() {

        return vehicleSold.getPrice() * 0.05;
    }

    public void setSalexTaxAmount(double saleTaxAmount) {
        this.saleTaxAmount = saleTaxAmount;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    //    public int getRecordingfee() {
//        return recordingfee;
//    }
//
//    public void setRecordingfee(int recordingfee) {
//        this.recordingfee = recordingfee;
//    }

    public double getProcessingFee() {
        if(vehicleSold.getPrice() > 10000){
            return 495;
        }
        return 295;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }


    // this monthly payment menthod is not taking into consideration
    //the sales tax, processing fee or recording fee
    @Override
    public double monthlyPayment() {

        if(vehicleSold.getPrice() > 10000){
            double interest = vehicleSold.getPrice() * 0.0425;
            double carTotal = vehicleSold.getPrice() + interest;

            return (carTotal/48);

        }

        double interest = vehicleSold.getPrice() * 0.0525;
        double carTotal = vehicleSold.getPrice() + interest;


        return (carTotal/12);
    }

    //this getTotal price method is taking into consideration all of the fees
    @Override
    public double getTotalPrice() {
        double salesTax = getSalexTaxAmount();
        double processingFee = getProcessingFee();

        return salesTax+processingFee+recordingFee+ vehicleSold.getPrice();
    }
}

////
//
//
//
//        }
//
//if (monthlyPaymentisFinanced > 10_000)
//  //  System.out.println("Loans that are more than $10000 will be financed at 4.25% for 48 monts")
////else{
//        ////System.out.println("Vehicles less than $10000 will be financed at 5.25% for 24 monts)
