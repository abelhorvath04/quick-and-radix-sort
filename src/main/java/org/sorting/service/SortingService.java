package org.sorting.service;

import org.sorting.fileReader.FileReader;
import org.sorting.quick.Quick;
import org.sorting.radix.Radix;

import java.util.ArrayList;
import java.util.Scanner;

public class SortingService {
    private final Quick quickSort = new Quick();
    private final Radix radixSort = new Radix();
    private final FileReader fileReader = new FileReader();
    private final Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user for a list of integers separated by commas and processes the input.
     * This method collects user input, processes it to ensure the input is valid integers,
     * and returns the list of integers.
     *
     * @return an ArrayList containing the integers entered by the user.
     */
    public ArrayList<Integer> getNumbersFromUser() {
        System.out.println("Write a list of integers separated by a comma:");
        System.out.println("For example: 1, 2, 3, 4, 5");
        System.out.println("+++");
        String userInput = sc.nextLine();
        return processListFromUserInput(userInput);
    }

    /**
     * Processes the user input string into a list of integers.
     * The input string is split by commas, and each value is parsed to an integer.
     * If the input is invalid, an error message is displayed.
     *
     * @param userInput the raw string input from the user.
     * @return an ArrayList of integers parsed from the input string.
     */
    private ArrayList<Integer> processListFromUserInput(String userInput) {
        String[] userInputArray = userInput.split(",");
        ArrayList<Integer> userInputList = new ArrayList<>();
        for (String s : userInputArray) {
            if (!s.isEmpty()) {
                try {
                    Integer listElement = Integer.parseInt(s.trim());
                    userInputList.add(listElement);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input for: '" + s.trim() + "'");
                }
            }
        }
        return userInputList;
    }

    /**
     * Reads integers from a file, where the numbers are separated by semicolons.
     * The file is read using the FileReader's semicolon-based reader method.
     *
     * @param fileName the name of the file to read.
     * @return an ArrayList containing integers parsed from the file.
     */
    public ArrayList<Integer> getNumbersFromFileBySemicolon(String fileName) {
        return fileReader.fileReaderBySemicolon(fileName);
    }

    /**
     * Reads integers from a file, line by line.
     * The file is read using the FileReader's line-by-line reader method.
     *
     * @param fileName the name of the file to read.
     * @return an ArrayList containing integers parsed from the file.
     */
    public ArrayList<Integer> getNumbersLineByLine(String fileName) {
        return fileReader.fileReaderLineByLine(fileName);
    }

    /**
     * Sorts the given list of numbers based on the specified sorting algorithm.
     * The method chooses the sorting algorithm based on the provided sort type.
     *
     * @param sortType the type of sorting algorithm to use (e.g., "quick", "radix").
     * @param numbers  the list of integers to be sorted.
     */
    public void sortNumbers(String sortType, ArrayList<Integer> numbers) {
        switch (sortType) {
            case "quick" -> quickSort.sort(numbers);
            case "radix" -> radixSort.sort(numbers);
            default -> System.out.println("Invalid sort type!");
        }
    }
}
