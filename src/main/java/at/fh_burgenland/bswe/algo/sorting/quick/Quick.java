package at.fh_burgenland.bswe.algo.sorting.quick;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Quick {

    private static final Logger logger = LogManager.getLogger(Quick.class);
    private int iterationCount;

    /**
     * Sorts the given list of integers using the QuickSort algorithm.
     *
     * @param numbers the list of integers to be sorted.
     */
    public void sort(ArrayList<Integer> numbers) {
        iterationCount = 0;
        long startTime = System.nanoTime();

        quickSort(numbers, 0, numbers.size() - 1);

        long endTime = System.nanoTime();
        long durationInNanoseconds = (endTime - startTime);


        double durationInSeconds = durationInNanoseconds / 1_000_000_000.0;
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;

        logger.debug("QuickSort execution time: {} seconds ({} milliseconds)", durationInSeconds, durationInMilliseconds);
        logger.info("Total iterations: " + iterationCount);
    }


    /**
     * Partition function that places the pivot element at the correct position in the list.
     *
     * @param arr  the list of integers.
     * @param low  the starting index of the list section to consider.
     * @param high the ending index of the list section to consider.
     * @return the index of the pivot element after partitioning.
     */
    private int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr.get(j) < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Swap two elements in the list.
     *
     * @param arr the list of integers.
     * @param i   the index of the first element.
     * @param j   the index of the second element.
     */
    private void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /**
     * QuickSort algorithm implementation that recursively sorts the list.
     *
     * @param arr  the list of integers to be sorted.
     * @param low  the starting index of the list section to consider.
     * @param high the ending index of the list section to consider.
     */
    private void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);

            iterationCount++;

            logger.debug("Iteration " + iterationCount + " completed: " + arr);
        }
    }
}
