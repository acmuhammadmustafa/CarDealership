package com.pluralsight;

import java.util.List;

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