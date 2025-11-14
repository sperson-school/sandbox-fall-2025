package org.example.sandbox.search;

import java.util.OptionalInt;

public class SearchUtility {

    public static int linearSearch(int[] array, int target) {

        OptionalInt found = optionalLinearSearch(array, target);
        return found.orElseThrow(() -> new IllegalArgumentException("Target not found in array"));
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


}
