package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicles car = new Vehicles();
        VehiclesList Instance = VehiclesList.getInstance();
        Vehicles truck = new Vehicles();
        Vehicles motorCycle = new Vehicles();

        car.setName("Honda");
        car.setColour("blue");
        car.setLicensePlate("87787");
        car.setVehicleType("car");
        car.setPricePerDay(9500000);
        Instance.addVehicles(car);

        truck.setVehicleType("truck");
        truck.setName("FUSO");
        truck.setColour("Black");
        truck.setLicensePlate("898765");
        truck.setPricePerDay(250000);
        Instance.addVehicles(truck);


        motorCycle.setVehicleType("Motocycle");
        motorCycle.setName("BMW");
        motorCycle.setColour("WHITE");
        motorCycle.setLicensePlate("453367");
        motorCycle.setPricePerDay(4500000);
        Instance.addVehicles(motorCycle);

        buyVehicleMenu();
    }

    public static void buyVehicleMenu() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
//        Vehicles vehicles = Vehicles.getInstance();
        VehiclesList Instance = VehiclesList.getInstance();
        String name, address, age, type;
        while (true) {
            System.out.println("Welcome to vehicle shop");
            System.out.println("Please choose from the list");
            Instance.listVehicles();
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
            if (Instance.vehicleExist(type)) {
                Instance.saveCustomer(customer, type);
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

class VehiclesList {
    List<Vehicles> vehiclesToRent;
    Map<String, Vehicles> vehiclesList;
    private static VehiclesList Instance;

    private VehiclesList() {
        vehiclesToRent = new ArrayList<>();
        vehiclesList = new HashMap<>();
    }

    public static VehiclesList getInstance() {
        if (Instance != null) {
            return Instance;
        }
        Instance = new VehiclesList();
        return Instance;
    }

    public void addVehicles(Vehicles vehicle) {
        vehiclesToRent.add(vehicle);
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
        for(int i = 0; i < vehiclesToRent.size(); i++) {
            Vehicles vehicle = vehiclesToRent.get(i);
            System.out.println(i + " - " + vehicle.getName());
            System.out.println("Type - " + vehicle.getVehicleType());
            System.out.println("Rent Price -  " + vehicle.getPricePerDay());
            System.out.println("Colour - " + vehicle.getColour());
            System.out.println("License Plate - " + vehicle.getLicensePlate());
//            System.out.println("1 - " + vehicle.get());
            System.out.println("==========================");
        }
    }

    public void saveCustomer(Customer customer, String type) {
        this.vehiclesList.put(customer.getName(), BuyVehicle(type));
        System.out.println("Vehicle rented successfully 😊");
    }
}

class Vehicles {
    private String licensePlate, colour, name, vehicleType;
    private double pricePerDay;


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


}

//cars, trucks and motorcycles

