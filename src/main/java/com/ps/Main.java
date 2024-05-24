package com.ps;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.display();
<<<<<<< HEAD

        Vehicle honda = new Vehicle(1233654467, 2024, "Honda", "Accord"
                , "4-door", "Blue", 1000, 8000);

/// getting values from a user, passing those values in probably use scanner. are the only logic
        SalesContract salesContract = new SalesContract();

        Contract salesChild = new SalesContract();

        Contract leaseChild = new LeaseContract();

        salesChild.setVehicleSold(honda);
        leaseChild.setVehicleSold(honda);

        System.out.println("Sales version of the contract for the honda vehicle we created");
        System.out.println(salesChild.monthlyPayment());

        System.out.println("Sales version of the contract for the honda vehicle we created");
        System.out.println(leaseChild.monthlyPayment());


    }
}

/// contract-abstract method is written as it. There is no implentation
///Sales contract- with the getter for vehicle we can write the ge

// put a method that handles case 10 which is leasing or selling a vehicle
// use scanner to get user info
=======
    }
}
>>>>>>> origin/main
