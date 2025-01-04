package at.fh_burgenland.bswe.algo.sorting.menu;

import at.fh_burgenland.bswe.algo.sorting.controller.SortingController;

import java.util.Scanner;

public class SortingMenu {
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
                1 - Add numbers manually
                2 - Read numbers from file
                
                9 - Back to Main Menu
                """;
        System.out.println(menu);
    }

    /**
     * Show File Reading Submenu.
     */
    public static void printFileReadMenu() {
        String menu = """
                1 - Read file line by line
                2 - Read file with ';' delimiter
                
                9 - Back to Sub Menu
                """;
        System.out.println(menu);
    }

    /**
     * Show Line-by-Line Reading Submenu.
     */
    public static void printLineByLineOptions() {
        String menu = """
                1 - Numbers between 1-100
                2 - Numbers between 1-1000
                3 - Numbers greater than 1000
                
                9 - Back to File Reading Menu
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
                        case "1" -> SortingController.sortManually(selectedSortType);
                        case "2" -> currentState = "FILE_MENU";
                        case "9" -> currentState = "MAIN_MENU";
                        default -> System.out.println("Wrong input!");
                    }
                }
                case "FILE_MENU" -> {
                    printFileReadMenu();
                    String fileMenuInput = sc.nextLine();
                    switch (fileMenuInput) {
                        case "1" -> currentState = "LINE_BY_LINE_MENU";
                        case "2" -> SortingController.sortFromFileDelimited(selectedSortType);
                        case "9" -> currentState = "SUB_MENU";
                        default -> System.out.println("Wrong input!");
                    }
                }
                case "LINE_BY_LINE_MENU" -> {
                    printLineByLineOptions();
                    String lineMenuInput = sc.nextLine();
                    switch (lineMenuInput) {
                        case "1" -> SortingController.sortFromFileLineByLine(selectedSortType, "1-100");
                        case "2" -> SortingController.sortFromFileLineByLine(selectedSortType, "1-1000");
                        case "3" -> SortingController.sortFromFileLineByLine(selectedSortType, ">1000");
                        case "9" -> currentState = "FILE_MENU";
                        default -> System.out.println("Wrong input!");
                    }
                }
            }
        }
    }
}
