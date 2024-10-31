package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        buyVehicleMenu();
    }

    public static void buyVehicleMenu() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        Vehicles vehicles = new Vehicles();
        String name, address, age, type;
        while (true) {
            System.out.println("Welcome to vehicle shop");
            System.out.println("Please choose from the list");
            vehicles.listVehicles();
            System.out.println();
            System.out.print("Name: ");
            name = scanner.nextLine();
            customer.setName(name);
            System.out.println();
            System.out.print("Address: ");
            address = scanner.nextLine();
            customer.setAddress(address);
            System.out.println();
            System.out.println("Age: ");
            age = scanner.nextLine();
            customer.setAddress(age);
            System.out.println();
            System.out.print("Vehicle type: ");
            type = scanner.nextLine();
            if (vehicles.vehicleExist(type)) {
                vehicles.saveCustomer(customer, type);
            } else {
                System.out.println("vehicle not available");
                break;
            }
        }
    }
}

class Customer {
    private String name, address, age;
    public Customer () {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String age() {
        return age;
    }
}

class Vehicles {
    private String licensePlate, colour, name, vehicleType;
    private double pricePerDay;
    List<Vehicles> vehiclesToRent = new ArrayList<>();
    Map<String, Vehicles> vehiclesList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Customer customer = new Customer();

    Vehicles() {
        Vehicles car = new Vehicles();
        Vehicles truck = new Vehicles();
        Vehicles motorCycle = new Vehicles();

        car.setName("Honda");
        car.setColour("blue");
        car.setLicensePlate("87787");
        car.setVehicleType("car");

        truck.setVehicleType("truck");
        truck.setName("FUSO");
        truck.setColour("Black");
        truck.setLicensePlate("898765");

        motorCycle.setVehicleType("truck");
        motorCycle.setName("FUSO");
        motorCycle.setColour("Black");
        motorCycle.setLicensePlate("898765");

        vehiclesToRent.add(car);
        vehiclesToRent.add(truck);
        vehiclesToRent.add(motorCycle);

    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public boolean vehicleExist(String type) {
        for (Vehicles vehicle : vehiclesToRent) {
            if (vehicle.getVehicleType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public Vehicles BuyVehicle(String type) {
        for (Vehicles vehicle : vehiclesToRent) {
            if (vehicle.getVehicleType().equals(type)) {
                return vehicle;
            }
        }
        return null;
    }

    public void listVehicles() {
        for(Vehicles vehicle : vehiclesToRent) {
            System.out.println("1 - " + vehicle.getName());
            System.out.println("1 -  " + vehicle.getPricePerDay());
            System.out.println("1 - " + vehicle.getColour());
            System.out.println("==========================");
        }
    }

    public void saveCustomer(Customer customer, String type) {
        this.vehiclesList.put(customer.getName(), BuyVehicle(type));
        System.out.println("Vehicle rented successfully 😊");
    }
}

//cars, trucks and motorcycles

