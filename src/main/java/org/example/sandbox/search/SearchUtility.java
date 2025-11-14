package org.example.sandbox.search;

import java.util.OptionalInt;

public class SearchUtility {

    public static int linearSearch(int[] array, int target) {

        OptionalInt found = optionalLinearSearch(array, target);
        int returnIndex = 0;
        try{
            returnIndex = found.orElseThrow(() -> new IllegalArgumentException("Target not found in array"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return returnIndex;
    }

    private static OptionalInt optionalLinearSearch(int[] array, int target) {

        OptionalInt found = OptionalInt.empty();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                found = OptionalInt.of(i);
                break;
            }
        }
        return found;
    }

    public static int binarySearchIterative(int[] array, int targetValue) {

        int min = 0;
        int max = array.length - 1;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (array[mid] == targetValue) {
                return mid;
            } else if (array[mid] < targetValue) {
                // If target is greater, ignore left half of array
                min = mid + 1;
            } else if (array[mid] > targetValue) {
                // if target is smaller, ignore right half of array
                max = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] array, int targetValue) {
        return binarySearchRecursiveHelper(array, 0, array.length - 1, targetValue);
    }

    private static int binarySearchRecursiveHelper(int[] array, int minIndex, int maxIndex, int targetValue) {

        if (minIndex > maxIndex) {
            return -1; // Base case: target not found
        }

        int midIndex = minIndex + (maxIndex - minIndex) / 2;

        if (array[midIndex] == targetValue) {
            return midIndex; // Target found
        } else if (array[midIndex] < targetValue) {
            return binarySearchRecursiveHelper(array, midIndex + 1, maxIndex, targetValue); // Search in the right half
        } else {
            return binarySearchRecursiveHelper(array, minIndex, midIndex - 1, targetValue); // Search in the left half
        }
    }
}
