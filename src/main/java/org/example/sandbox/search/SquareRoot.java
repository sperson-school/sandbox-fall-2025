package org.example.sandbox.search;

import java.util.Set;
import java.util.TreeSet;

/**
 * Example of an application of a binary search algorithm.
 * <p>
 * Uses a min, mid and max value to determine the square root of a number.  Starting point is the number entered divided
 * by two.  A precision is used to determine when to stop guessing.  Code is added to handle situations where parasitic
 * oscillations occur that cause the same value to be guessed over and over again.
 * <p>
 */
public class SquareRoot {

    public static double calculateFor(double operand) {
        return calculateFor(operand, 0.000000001);
    }

    public static double calculateFor(double operand, double precision) {

        // no negative numbers
        if (operand < 0) {
            return -1;
        }

        // Initialize datum
        Datum datum = new Datum();
        Set<Double> guesses = new TreeSet<>();

        datum.min = 0.0;
        datum.max = operand;
        datum.mid = 0.0;
        datum.number = operand;
        datum.precision = precision;

        // Iterate until an in-tolerance guess is made
        while (outOfTolerance(datum)) {

            // calculate mid point
            datum.mid = (datum.min + datum.max) / 2.0;
            System.out.print("Guess: " + datum.mid + " ");

            // test for previous guess
            if (guesses.contains(datum.mid)) {
                System.out.println("Guess [" + datum.mid + "] is repeating - exiting");
                break;
            } else {
                guesses.add(datum.mid);
            }

            double guessSquared = Math.pow(datum.mid, 2.0);
            boolean outOfTolerance = outOfTolerance(datum);
            if (outOfTolerance && (guessSquared > operand)) {
                datum.max = datum.mid;
                System.out.println(" - Guess Too High - lowering max");
            } else if (outOfTolerance && (guessSquared < operand)) {
                datum.min = datum.mid;
                System.out.println(" - Guess Too Low - raising min");
            } else {
                System.out.println("\nGuess [" + datum.mid + "] is correct with [" + datum.precision + "] precision");
                break;
            }

        }

        return datum.mid;
    }

    /**
     * Used to determine if calculated square root is within tolerance.
     *
     * @param datum
     * @return
     */
    private static boolean outOfTolerance(Datum datum) {
        return (Math.abs(Math.pow(datum.mid, 2.0) - datum.number) >= datum.precision);
    }

    /**
     * Class used to hold data related to square root search/guess.
     */
    private static class Datum {

        double min;
        double max;
        double mid;

        double number;
        double precision;

    }

}

