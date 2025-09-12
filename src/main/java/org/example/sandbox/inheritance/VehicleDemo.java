package org.example.sandbox.inheritance;

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020, 15.8, 28);
        car.displayInfo();
        car.start();
        System.out.println("Car Range: " + car.calculateRange() + " miles");
        System.out.println("Car Max Speed: " + car.getMaxSpeed() + " mph");
        car.honk();
        car.openTrunk();
        car.refuel();
        car.stop();

        System.out.println();

        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2019, 3.5, false, 55);
        motorcycle.displayInfo();
        motorcycle.start();
        System.out.println("Motorcycle Range: " + motorcycle.calculateRange() + " miles");
        System.out.println("Motorcycle Max Speed: " + motorcycle.getMaxSpeed() + " mph");
        motorcycle.honk();
        motorcycle.wheelie();
        motorcycle.refuel();
        motorcycle.stop();

        System.out.println();

        Helicopter helicopter = new Helicopter("Boeing", "747", 2015, 183380, 8, 35000);
        helicopter.displayInfo();
        helicopter.start();
        helicopter.takeOff();
        System.out.println("Airplane Range: " + helicopter.calculateRange() + " miles");
        System.out.println("Airplane Max Speed: " + helicopter.getMaxSpeed() + " mph");
        System.out.println("Airplane Max Altitude: " + helicopter.getMaxAltitude() + " feet");
        helicopter.honk();
        helicopter.hover();
        helicopter.land();
        helicopter.refuel();
        helicopter.stop();

        // Display driving tips using static method from Drivable interface
        Drivable.displayDrivingTips();

        Vehicle[] vehicles = {car, motorcycle, helicopter};
        System.out.println("polymorphism demo:");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("Range: " + v.calculateRange() + " miles");
            System.out.println("Max Speed: " + v.getMaxSpeed() + " mph");
            v.start();
            v.honk();
            v.stop();
            v.refuel();
            System.out.println();
        }
    }
}
