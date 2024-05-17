package com.ps;


public class contractDataManager {

    public void saveContract(Contract contract) {
        if (contract instanceof SalesContract) {
            saveSalesContract((SalesContract) contract);
        } else if (contract instanceof LeaseContract) {
            saveLeaseContract((LeaseContract) contract);
        } else {
            System.out.println("Unknown contract type");
        }
    }

    private void saveSalesContract(SalesContract contract) {
        // Logic to save a sales contract
        System.out.println("Saving Sales Contract");
    }

    private void saveLeaseContract(LeaseContract contract) {
        // Logic to save a lease contract
        System.out.println("Saving Lease Contract");
    }
}
