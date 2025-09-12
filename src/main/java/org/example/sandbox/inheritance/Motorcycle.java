package org.example.sandbox.inheritance;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, double fuelCapacity, boolean hasSidecar, double mpg) {
        super(brand, model, year, fuelCapacity, mpg);
        this.hasSidecar = hasSidecar;
        this.mpg = mpg;
    }

    @Override
    public double calculateRange() {
        return fuelCapacity * mpg;
    }

    @Override
    public void start() {
        System.out.println("Started the motorcycle.");
    }

    @Override
    public void stop() {
        System.out.println("Stopped the motorcycle.");
    }

    @Override
    public double getMaxSpeed() {
        return hasSidecar ? 85.0 : 140.0; // Max speed in mph
    }

    // Override refuel method
    @Override
    public void refuel() {
        System.out.println("Refueling the " + brand + " " + model);
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    @Override
    public void honk() {
        System.out.println("Motorcycle beep beep!");
    }

    public void wheelie() {
        if (!hasSidecar) {
            System.out.println("Doing a wheelie!");
        } else {
            System.out.println("Cannot do a wheelie with a sidecar.");
        }
    }
}
