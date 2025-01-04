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

    public ArrayList<Integer> getNumbersFromUser() {
        System.out.println("Write a list of integers separated by a comma:");
        System.out.println("For example: 1, 2, 3, 4, 5");
        System.out.println("+++");
        String userInput = sc.nextLine();
        return processListFromUserInput(userInput);
    }

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

    public ArrayList<Integer> getNumbersFromFile(String fileName) {
        return fileReader.fileReader(fileName);
    }

    public void sortNumbers(String sortType, ArrayList<Integer> numbers) {
        switch (sortType) {
            case "quick" -> quickSort.sort(numbers);
            case "radix" -> radixSort.sort(numbers);
            default -> System.out.println("Invalid sort type!");
        }
    }
}
