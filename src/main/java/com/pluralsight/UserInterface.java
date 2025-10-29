package com.pluralsight;

import java.util.*;

public class UserInterface {

    // -----------------------------------------------------------

    // Page 7 introducing "dealership : Dealership"
    Dealership dealership;
    int command;
    // -----------------------------------------------------------
    public void userInterface() {
        init();

        System.out.println();
        System.out.println();

        do {
            String display = """
                ====== Dealership Menu ======
                 \
                Choose an option:\s
                 \
                1) Price
                 \
                2) Make/Model
                 \
                3) Year
                 \
                4) Color
                 \
                5) Mileage
                 \
                6) Vehicle Type
                 \
                7) All Vehicles
                 \
                8) Add a Vehicle
                 \
                9) Remove a Vehicle
                 \
                99) Exit\s
                 \
                ==========================
                """;
            System.out.println(display);


            command = ConsoleHelper.promptForInt("Enter your command".trim());
            System.out.println();
            switch (command) {
                case 1:
                    processGetByPriceRequest();
                    System.out.println("\n======================\n");
                    break;

                case 2:
                    processGetByMakeModelRequest();
                    System.out.println("\n======================\n");
                    break;

                case 3:
                    processGetByYearRequest();
                    System.out.println("\n======================\n");
                    break;

                case 4:
                    processGetByColorRequest();
                    System.out.println("\n======================\n");
                    break;

                case 5:
                    processGetByMileageRequest();
                    System.out.println("\n======================\n");
                    break;

                case 6:
                    processGetByVehicleTypeRequest();
                    System.out.println("\n======================\n");
                    break;

                case 7:
                    processGetAllVehiclesByRequest();
                    System.out.println("\n======================\n");
                    break;

                case 8:
                    processAddVehicleRequest();
                    System.out.println("\n======================\n");
                    break;

                case 9:
                    processRemoveVehicleRequest();
                    System.out.println("\n======================\n");
                    break;

                case 99:
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println("======================\n");
            }
        } while (true);
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void processGetByPriceRequest() {
        float minPrice = ConsoleHelper.promptForFloat("Please enter the minimum price range you're searching for");
        float maxPrice = ConsoleHelper.promptForFloat("Please enter the maximum price range you're searching for");

        List<Vehicle> vehicles = dealership.getVehicleByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        java.lang.String makeRequest = ConsoleHelper.promptForString("Please enter the make");
        java.lang.String modelRequest = ConsoleHelper.promptForString("Please enter the model");

        List<Vehicle> vehicles = dealership.getVehicleByMakeModel(makeRequest, modelRequest);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        int minimumYear = ConsoleHelper.promptForInt("Please enter the minimum year range you're searching for");
        int maximumYear = ConsoleHelper.promptForInt("Please enter the maximum year range you're searching for");

        List<Vehicle> vehicles = dealership.getVehicleByYear(minimumYear, maximumYear);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        java.lang.String colorRequest = ConsoleHelper.promptForString("Please enter vehicle's color");
        List<Vehicle> vehicles = dealership.getVehicleByColor(colorRequest);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        int minimumMileage = ConsoleHelper.promptForInt("Please enter the minimum mileage range you're searching for");
        int maximumMileage = ConsoleHelper.promptForInt("Please enter the maximum mileage range you're searching for");

        List<Vehicle> vehicles = dealership.getVehicleByMileage(minimumMileage, maximumMileage);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        java.lang.String vehicleTypeRequest = ConsoleHelper.promptForString("Please enter the vehicle type");
        List<Vehicle> vehicles = dealership.getVehicleByType(vehicleTypeRequest);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesByRequest() {
        List<Vehicle> vehicles = dealership.getInventory();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        int getVin = ConsoleHelper.promptForInt("Enter vehicle's VIN");
        int getYear = ConsoleHelper.promptForInt("Enter vehicle's year");
        String getMake = ConsoleHelper.promptForString("Enter vehicle's make");
        String getModel = ConsoleHelper.promptForString("Enter vehicle's model");
        String getType = ConsoleHelper.promptForString("Enter vehicle's type");
        String getColor = ConsoleHelper.promptForString("Enter vehicle's color");
        int getOdo = ConsoleHelper.promptForInt("Enter vehicle's odometer");
        double getPrice = ConsoleHelper.promptForDouble("Enter vehicle's price");

        Vehicle newVehicle = new Vehicle(getVin,getYear,getMake,getModel,getType,getColor,getOdo,getPrice);

        dealership.addVehicle(newVehicle);

        DealershipFileManager fm = new DealershipFileManager();
        fm.saveDealership(dealership);

    }

    public void processRemoveVehicleRequest() {
        // Show all vehicles so user can see VINs
        System.out.println("Current inventory:");
        displayVehicles(dealership.getAllVehicles());

        // Prompt for VIN
        int vinToRemove = ConsoleHelper.promptForInt("Enter the VIN of the vehicle to remove");

        // Try to find the vehicle
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vinToRemove) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        // Remove if found
        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println("Vehicle removed successfully!");

            // Save the updated dealership
            DealershipFileManager fm = new DealershipFileManager();
            fm.saveDealership(dealership);
        } else {
            System.out.println("Vehicle with VIN " + vinToRemove + " not found.");
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}