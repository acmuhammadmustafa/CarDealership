package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByYear(int min, int max) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByColor(String color) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByMileage(int max, int min) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByType(String type) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                result.add(vehicle);
            }
        }
        return result;
    }
// ----------------------------------------------------------------
    @Override
    public String toString() {
        return "Dealership Information == " +
                "Name: " + name +
                " | Address: " + address +
                " |Phone: " + phone +
                " ==" + '\n';
    }
}