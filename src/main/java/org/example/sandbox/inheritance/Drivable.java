package org.example.sandbox.inheritance;

public interface Drivable {

    int MAX_SPEED = 120;

    void start();
    void stop();
    double getMaxSpeed();

    default void honk() {
        System.out.println("Beep beep!");
    }

    static void displayDrivingTips() {
        System.out.println("Always wear your seatbelt!");
    }
}
