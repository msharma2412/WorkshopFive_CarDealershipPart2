package com.ps;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private static Scanner scanner = new Scanner(System.in);


//    hint: Updates were rejected because the tip of your current branch is behind
//    Done
//    hint: its remote counterpart. Integrate the remote changes (e.g.
//                                                                        hint: 'git pull ...') before pushing again.
//    hint: See the 'Note about fast-forwards' in 'git push --help' for details.
//23:23:38.397: [WorkshopFive_CarDealershipPart2] git -c credential.helper= -c core.quotepath=false -c log.showSignature=false fetch origin --recurse-submodules=no --progress --prune
//23:23:40.469: [WorkshopFive_CarDealershipPart2] git -c credential.helper= -c core.quotepath=false -c log.showSignature=false merge origin/main --no-stat -v
//    fatal: refusing to merge unrelated histories
//
//







    public void display(){
        init();

        int mainMenuCommand;

        do{
            // Needs refactoring
            System.out.println("1- Find vehicles within a price range");
            System.out.println("2- Find vehicles by make / model");
            System.out.println("3- Find vehicles by year range");
            System.out.println("4- Find vehicles by color");
            System.out.println("5- Find vehicles by mileage range");
            System.out.println("6- Find vehicles by type (sedan, truck, SUV, van)");
            System.out.println("7- List ALL vehicles");
            System.out.println("8- Add a vehicle");
            System.out.println("9- Remove a vehicle");
            System.out.println("99- Quit");

            System.out.print("Please choose an option: ");

            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    // process to sell or lease vehicle.








                    case 99:
                    break;
            }
        } while(mainMenuCommand != 99);
    }

    private void init(){
        this.dealership = DealershipFileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles){

        for(Vehicle vehicle: vehicles){
//            "----  All Vehicles ----
            System.out.printf("VIN: %d, Year: %d, Make: %s, Model: %s, Type: %s, Color: %s, Odometer: %d, Price: %.2f\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );
        }
    }

    public void processGetByPriceRequest(){
        System.out.print("Minimum price: ");
        int min = scanner.nextInt();
        System.out.print("Maximum price: ");
        int max = scanner.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(filteredVehicles);
    }
    public void processGetByMakeModelRequest(){
        scanner.nextLine(); // Consume Line

        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(filteredVehicles);
    }
    public void processGetByYearRequest(){
        System.out.print("Minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Maximum year: ");
        int max = scanner.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehicleByYear(min, max);
        displayVehicles(filteredVehicles);
    }
    public void processGetByColorRequest(){
        scanner.nextLine(); // Consume Line

        System.out.print("Color: ");
        String color = scanner.nextLine();

        List<Vehicle> filteredVehicles = dealership.getVehicleByColor(color);
        displayVehicles(filteredVehicles);
    }
    public void processGetByMileageRequest(){
        System.out.print("Minimum Mileage: ");
        int min = scanner.nextInt();
        System.out.print("Maximum Mileage: ");
        int max = scanner.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(filteredVehicles);
    }
    public void processGetByVehicleTypeRequest(){
        scanner.nextLine(); // Consume Line

        System.out.print("Vehicle type: ");
        String type = scanner.nextLine();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByType(type);
        displayVehicles(filteredVehicles);
    }
    public void processGetAllVehiclesRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        System.out.println("------ All Vehicles ------");
        displayVehicles(allVehicles);
    }
    public void processAddVehicleRequest(){
        System.out.print("VIN: ");
        int vin = scanner.nextInt();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        // Fix: Consume extra carriage
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        this.dealership.addVehicle(vehicle);

        DealershipFileManager.saveDealership(this.dealership);
    }
    public void processRemoveVehicleRequest(){
        List<Vehicle> allVehicles = this.dealership.getAllVehicles();
        displayVehicles(allVehicles);
        System.out.print("Which would you like to remove? VIN: ");
        int vin = scanner.nextInt();

        for(Vehicle vehicle: allVehicles){
            if(vehicle.getVin() == vin){
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle found and removed");
                DealershipFileManager.saveDealership(this.dealership);
                return;
            }
        }


        System.out.println("Vehicle not found");

//        public static Dealership getDealership() {
//            try {
//                BufferedReader bufReader = new BufferedReader(new FileReader("DB_Dealership.csv"));
//
//                String firstLine = bufReader.readLine();
//                String[] splitFirstLine = firstLine.split("\\|");
//
//                String name = splitFirstLine[0];
//                String address = splitFirstLine[1];
//                String phone = splitFirstLine[2];
//
//                Dealership dealership = new Dealership(name, address, phone);

    }

            public void start() {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Enter command (1: Create Contract, 0: Exit): ");
                    int command = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    if (command == 1) {
                        createContract(scanner);
                    } else if (command == 0) {
                        break;
                    } else {
                        System.out.println("Invalid command");
                    }
                }
            }

            private void createContract(Scanner scanner) {
                System.out.println("Enter contract type (sales/lease): ");
                String type = scanner.nextLine();

                System.out.println("Enter vehicle ID: ");
                String vehicleId = scanner.nextLine();

                System.out.println("Enter customer name: ");
                String customerName = scanner.nextLine();

                System.out.println("Enter contract details: ");
                String details = scanner.nextLine();

                Contract contract;
                if ("sales".equalsIgnoreCase(type)) {
                    SalesContract salesContract = new SalesContract();

//                    private double saleTaxAmount;
//                    private static int recordingFee = 100;
//                    private double processingFee;
//                    private boolean finance;




                } else if ("lease".equalsIgnoreCase(type)) {
                   LeaseContract leaseContract = new LeaseContract();
                } else {
                    System.out.println("Unknown contract type");
                    return;
                }

                System.out.println(type.substring(0, 1).toUpperCase() + type.substring(1) + " Contract created and vehicle removed from inventory.");
            }

            public static void main(String[] args) {
                ContractDataManager contractDataManager = new ContractDataManager();
                InventoryManager inventoryManager = new InventoryManager();

            }
        }

// Simplified ContractDataManager for demonstration
        class ContractDataManager {

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
                System.out.println("Saving Sales Contract for vehicle ID: ");
            }

            private void saveLeaseContract(LeaseContract contract) {
                System.out.println("Saving Lease Contract for vehicle ID: ");
            }
        }

// Simplified InventoryManager for demonstration
        class InventoryManager {

            public void removeVehicle(String vehicleId) {
                System.out.println("Removing vehicle ID: " + vehicleId + " from inventory");
            }
        }



























