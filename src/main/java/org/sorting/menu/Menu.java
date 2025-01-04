package org.sorting.menu;

import org.sorting.Controller.Controller;

import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Prints the welcome text and the main menu for the user.
     */
    public static void printMenu() {
        String sortingText = """
                  _________              __  .__               
                 /   _____/ ____________/  |_|__| ____    ____ 
                 \\_____  \\ /  _ \\_  __ \\   __\\  |/    \\  / ___\\
                 /        (  <_> )  | \\/|  | |  |   |  \\/ /_/  >
                /_______  /\\____/|__|   |__| |__|___|  /\\___  /
                        \\/                           \\//_____/ 
                """;
        System.out.println(sortingText);

        String menu = """
                1 - Quick Sort
                2 - Radix Sort
                
                9 - Exit
                """;
        System.out.println(menu);
    }

    /**
     * Show Submenu.
     */
    public static void printSubMenu() {
        String menu = """
                1 - Add number manually
                2 - Read numbers from file
                
                9 - Back to Main Menu
                """;
        System.out.println(menu);
    }

    /**
     * Unified menu logic.
     */
    public static void programStart() {
        String currentState = "MAIN_MENU";
        String selectedSortType = "";

        while (true) {
            switch (currentState) {
                case "MAIN_MENU" -> {
                    printMenu();
                    String userInput = sc.nextLine();
                    switch (userInput) {
                        case "1" -> {
                            selectedSortType = "quick";
                            currentState = "SUB_MENU";
                        }
                        case "2" -> {
                            selectedSortType = "radix";
                            currentState = "SUB_MENU";
                        }
                        case "9" -> {
                            System.out.println("Exiting...");
                            return;
                        }
                        default -> System.out.println("Wrong input!");
                    }
                }
                case "SUB_MENU" -> {
                    printSubMenu();
                    String userSubMenuInput = sc.nextLine();
                    switch (userSubMenuInput) {
                        case "1" -> Controller.sortManually(selectedSortType);
                        case "2" -> Controller.sortFromFile(selectedSortType);
                        case "9" -> currentState = "MAIN_MENU";
                        default -> System.out.println("Wrong input!");
                    }
                }
            }
        }
    }
}
