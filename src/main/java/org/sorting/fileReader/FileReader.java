package org.sorting.fileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {
    public ArrayList<Integer> fileReaderBySemicolon(String fileName){
        Path path = Paths.get("src", "main", "resources", fileName);
        ArrayList<Integer> numbersFromFile = new ArrayList<>();

        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split(";");
                    for (String number : split) {
                        try {
                            numbersFromFile.add(Integer.parseInt(number.trim()));
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid number format: " + number);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.err.println("File does not exist: " + path);
        }

        return numbersFromFile;
    }

    public ArrayList<Integer> fileReaderLineByLine(String fileName){
        Path path = Paths.get("src", "main", "resources", fileName);
        ArrayList<Integer> numbersFromFile = new ArrayList<>();

        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        numbersFromFile.add(Integer.parseInt(line.trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format: " + line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.err.println("File does not exist: " + path);
        }

        return numbersFromFile;
    }
}
