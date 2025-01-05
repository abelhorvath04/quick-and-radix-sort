package at.fh_burgenland.bswe.algo.sorting.radix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

public class Radix {

    private static final Logger logger = LogManager.getLogger(Radix.class);

    private int iterationCount;

    /**
     * Utility function to find the maximum value in the list.
     *
     * @param arr The list of integers to search through
     * @return The maximum value found in the list
     */
    static int getMax(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max)
                max = arr.get(i);
        }
        return max;
    }

    /**
     * Function to perform counting sort on the list according to the digit represented by exp.
     * This function is used as part of the radix sort algorithm to sort the list by each digit.
     *
     * @param arr The list of integers to be sorted
     * @param exp The current digit's place value (1 for units, 10 for tens, etc.)
     */
    static void countSort(ArrayList<Integer> arr, int exp) {
        int n = arr.size();
        ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> count = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            count.add(0);
        }

        for (int i = 0; i < n; i++) {
            count.set((arr.get(i) / exp) % 10, count.get((arr.get(i) / exp) % 10) + 1);
        }

        for (int i = 1; i < 10; i++) {
            count.set(i, count.get(i) + count.get(i - 1));
        }

        for (int i = n - 1; i >= 0; i--) {
            output.set(count.get((arr.get(i) / exp) % 10) - 1, arr.get(i));
            count.set((arr.get(i) / exp) % 10, count.get((arr.get(i) / exp) % 10) - 1);
        }

        for (int i = 0; i < n; i++) {
            arr.set(i, output.get(i));
        }
    }

    /**
     * Main function to implement Radix Sort. It calls the countSort function for every digit place.
     *
     * @param arr The list of integers to be sorted
     */
    public void sort(ArrayList<Integer> arr) {
        iterationCount = 0;
        long startTime = System.nanoTime();

        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
            iterationCount++;
            logger.debug("Iteration " + iterationCount + " completed: " + arr);
        }


        long endTime = System.nanoTime();
        long durationInNanoseconds = (endTime - startTime);


        double durationInSeconds = durationInNanoseconds / 1_000_000_000.0;
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;

        logger.debug("QuickSort execution time: {} seconds ({} milliseconds)", durationInSeconds, durationInMilliseconds);
        logger.info("Total iterations: " + iterationCount);
    }
}
