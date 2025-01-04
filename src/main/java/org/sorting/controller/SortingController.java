package org.sorting.controller;

import org.sorting.service.SortingService;

import java.util.ArrayList;

public class SortingController {
    private static final SortingService sortingService = new SortingService();

    /**
     * Handles manual number sorting from user input.
     */
    public static void sortManually(String sortType) {
        System.out.println("Manual data input selected for: " + sortType);
        ArrayList<Integer> manualNumbers = sortingService.getNumbersFromUser();
        sortingService.sortNumbers(sortType, manualNumbers);
    }

    /**
     * Handles file reading with a specific delimiter and sorts the numbers.
     */
    public static void sortFromFileDelimited(String sortType, String delimiter) {
        System.out.println("File input selected with delimiter '" + delimiter + "' for: " + sortType);
        ArrayList<Integer> numbersFromFile = sortingService.getNumbersFromFile("digits.txt");
        sortingService.sortNumbers(sortType, numbersFromFile);
    }

    /**
     * Handles file reading line-by-line with a specific range and sorts the numbers.
     */
    public static void sortFromFileByRange(String sortType, String range) {
        System.out.println("File line-by-line input selected with range '" + range + "' for: " + sortType);
        ArrayList<Integer> numbersFromFile;

        switch (range) {
            case "1-100" ->
                    numbersFromFile = sortingService.getNumbersFromFile("1-100.txt");
            case "1-1000" ->
                    numbersFromFile = sortingService.getNumbersFromFile("1-1000.txt");
            case ">1000" ->
                    numbersFromFile = sortingService.getNumbersFromFile("bigger-than-1000.txt");
            default -> {
                System.out.println("Invalid range selection. Defaulting to all numbers from digits.txt");
                numbersFromFile = sortingService.getNumbersFromFile("digits.txt");
            }
        }

        sortingService.sortNumbers(sortType, numbersFromFile);
    }
}
