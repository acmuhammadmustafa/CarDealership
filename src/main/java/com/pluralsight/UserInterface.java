package com.pluralsight;

import java.util.List;

public class UserInterface {

    // -----------------------------------------------------------

    // Page 7 introducing "dealership : Dealership"
    Dealership dealership;
    int command;
    // -----------------------------------------------------------
    public UserInterface() {
        init();

        System.out.println();
        System.out.println();
        System.out.println("====== Reports Menu ======");
        String display = "Choose an option: \n " +
                "1) Price\n " +
                "2) Make/Model\n " +
                "3) Year\n " +
                "4) Color\n " +
                "5) Mileage\n " +
                "6) Vehicle Type\n " +
                "7) All Vehicles\n " +
                "8) Add a Vehicle\n " +
                "9) Remove a Vehicle\n " +
                "0) Exit \n " +
                "==========================\n";
        do {
            System.out.println(display);


            command = ConsoleHelper.promptForInt("Enter your command".trim());
            switch (command) {
                case 1:
                    processGetByPriceRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 2:
                    processGetByMakeModelRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 3:
                    processGetByYearRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 4:
                    processGetByColorRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 5:
                    processGetByMileageRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 6:
                    processGetByVehicleTypeRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 7:
                    processGetAllVehiclesByRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 8:
                    processAddVehicleRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 9:
                    processRemoveVehicleRequest();
                    System.out.println();
                    System.out.println("======================");
                    System.out.println();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    System.out.println("======================");
            }
        } while (true);
    }

    public void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void processGetByPriceRequest() {
    }

    public void processGetByMakeModelRequest() {
    }

    public void processGetByYearRequest() {
    }

    public void processGetByColorRequest() {
    }

    public void processGetByMileageRequest() {
    }

    public void processGetByVehicleTypeRequest() {
    }

    public void processGetAllVehiclesByRequest() {
        List<Vehicle> vehicles = dealership.getInventory();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {
    }



    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}