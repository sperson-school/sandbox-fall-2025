package org.example.sandbox.inheritance;

public class Helicopter extends Vehicle implements Flyable {

    private int rotorCount;

    public Helicopter(String brand, String model, int year, double fuelCapacity, int rotorCount, int mpg) {
        super(brand, model, year, fuelCapacity, mpg);
        this.rotorCount = rotorCount;
        this.mpg = mpg;
    }


    @Override
    public double calculateRange() {
        return 0;
    }

    @Override
    public void start() {
        System.out.println("Starting Helicopter");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Helicopter");
    }

    @Override
    public double getMaxSpeed() {
        return 160.0;
    }

    @Override
    public void takeOff() {
        System.out.println("Taking off Helicopter");
    }

    @Override
    public void land() {
        System.out.println("Landing Helicopter");
    }

    @Override
    public double getMaxAltitude() {
        return 15000.0; // in feet
    }

    public int getRotorCount() {
        return rotorCount;
    }

    public double getMpg() {
        return mpg;
    }


    @Override
    public void hover() {
        System.out.println("Helicopter is hovering in place.");
    }
}
