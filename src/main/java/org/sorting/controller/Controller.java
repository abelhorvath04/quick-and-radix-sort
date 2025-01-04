package org.sorting.controller;

import org.sorting.quick.Quick;
import org.sorting.radix.Radix;

public class Controller {
    private final static Quick quickSort = new Quick();
    private final static Radix radixSort = new Radix();

    public static void sortManually(String sortType) {
        
        System.out.println("Manual data input selected for: " + sortType);
        // TODO LOGIC OF THE DATA PROCESS -> by the end array with numbers
        SortingSelector(sortType);
    }

    public static void sortFromFile(String sortType) {
        System.out.println("File input selected for: " + sortType);
        // TODO LOGIC OF THE DATA PROCESS -> by the end array with numbers
        SortingSelector(sortType);
    }

    private static void SortingSelector(String sortType) {
        if (sortType.equals("quick")) {
            quickSort.sort();
        } else if (sortType.equals("radix")) {
            radixSort.sort();
        } else {
            System.out.println("Something went wrong!");
        }
    }

}
