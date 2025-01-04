package org.sorting.controller;

import org.sorting.fileReader.FileReader;
import org.sorting.quick.Quick;
import org.sorting.radix.Radix;

import java.util.ArrayList;

public class Controller {
    private final static Quick quickSort = new Quick();
    private final static Radix radixSort = new Radix();
    private final static FileReader fileReader = new FileReader();

    public static void sortManually(String sortType) {
        ArrayList<Integer> manualNumbers = new ArrayList<>();
        System.out.println("Manual data input selected for: " + sortType);
        // TODO LOGIC OF THE DATA PROCESS -> by the end array with numbers
        SortingSelector(sortType, manualNumbers);
    }

    public static void sortFromFile(String sortType) {
        ArrayList<Integer> numbersFromFile = fileReader.fileReader("digits.txt");
        System.out.println("File input selected for: " + sortType);
        // TODO LOGIC OF THE DATA PROCESS -> by the end array with numbers
        SortingSelector(sortType, numbersFromFile);
    }

    private static void SortingSelector(String sortType, ArrayList<Integer> numbers) {
        if (sortType.equals("quick")) {
            quickSort.sort(numbers);
        } else if (sortType.equals("radix")) {
            radixSort.sort(numbers);
        } else {
            System.out.println("Something went wrong!");
        }
    }

}
