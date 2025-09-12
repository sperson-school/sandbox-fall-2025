package org.example.sandbox.inheritance;

public class Car extends Vehicle {

    private int doors;

    public Car(String brand, String model, int year, double fuelCapacity, double mpg) {
        super(brand, model, year, fuelCapacity, mpg);
        this.doors = doors;
        this.mpg = mpg;
    }

    @Override
    public double calculateRange() {
        return fuelCapacity * mpg;
    }

    @Override
    public void start() {
        System.out.println("Started the car.");
    }

    @Override
    public void stop() {
        System.out.println("Stopped the car.");
    }

    @Override
    public double getMaxSpeed() {
        return MAX_SPEED; // Max speed in mph
    }

    // Override refuel method
    @Override
    public void refuel() {
        System.out.println("Refueling the " + brand + " " + model);
    }

    public void openTrunk() {
        System.out.println("Trunk is now open.");
    }

    public int getDoors() {
        return doors;
    }
}
