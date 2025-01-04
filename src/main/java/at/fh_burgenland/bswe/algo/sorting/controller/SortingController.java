package at.fh_burgenland.bswe.algo.sorting.controller;

import at.fh_burgenland.bswe.algo.sorting.service.SortingService;

import java.util.ArrayList;

public class SortingController {
    private static final SortingService sortingService = new SortingService();

    /**
     * Handles manual number sorting from user input.
     * This method prompts the user for manual input, collects the numbers,
     * and then sorts them based on the specified sorting algorithm.
     *
     * @param sortType the type of sorting algorithm to use (e.g., "quick", "radix")
     */
    public static void sortManually(String sortType) {
        System.out.println("Manual data input selected for: " + sortType);
        ArrayList<Integer> manualNumbers = sortingService.getNumbersFromUser();
        sortingService.sortNumbers(sortType, manualNumbers);
    }

    /**
     * Handles file reading with a specific delimiter and sorts the numbers.
     * This method reads a file where the numbers are separated by a delimiter (e.g., semicolon),
     * parses the numbers, and then sorts them according to the specified algorithm.
     *
     * @param sortType the type of sorting algorithm to use (e.g., "quick", "radix")
     */
    public static void sortFromFileDelimited(String sortType) {
        System.out.println("File input selected with delimiter ';' for: " + sortType);
        ArrayList<Integer> numbersFromFile = sortingService.getNumbersFromFileBySemicolon("digits.txt");
        sortingService.sortNumbers(sortType, numbersFromFile);
    }

    /**
     * Handles file reading line-by-line with a specific range and sorts the numbers.
     * This method reads a file line by line, based on the specified range (e.g., "1-100", "1-1000"),
     * and sorts the numbers according to the selected sorting algorithm.
     *
     * @param sortType the type of sorting algorithm to use (e.g., "quick", "radix")
     * @param range    the range of numbers to read from the file (e.g., "1-100", "1-1000", ">1000")
     */
    public static void sortFromFileLineByLine(String sortType, String range) {
        System.out.println("File line-by-line input selected with range '" + range + "' for: " + sortType);
        ArrayList<Integer> numbersFromFile;

        switch (range) {
            case "1-100" ->
                    numbersFromFile = sortingService.getNumbersLineByLine("1-100.txt");
            case "1-1000" ->
                    numbersFromFile = sortingService.getNumbersLineByLine("1-1000.txt");
            case ">1000" ->
                    numbersFromFile = sortingService.getNumbersLineByLine("bigger-than-1000.txt");
            default -> {
                System.out.println("Something went wrong. Defaulting to all numbers from digits.txt");
                numbersFromFile = sortingService.getNumbersFromFileBySemicolon("digits.txt");
            }
        }

        sortingService.sortNumbers(sortType, numbersFromFile);
    }
}
