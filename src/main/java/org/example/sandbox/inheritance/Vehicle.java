package org.example.sandbox.inheritance;

public abstract class Vehicle implements Drivable {

    protected String brand;
    protected String model;
    protected int year;
    protected double fuelCapacity;

    public Vehicle(String brand, String model, int year, double fuelCapacity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
    }

    public void displayInfo() {
        System.out.println("Vehicle Info: " + year + " " + brand + " " + model + ", Fuel Capacity: " + fuelCapacity + "L");
    }

    public abstract double calculateRange();

    public void refuel() {
        System.out.println("Refueling the " + brand + " " + model");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
