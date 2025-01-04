package at.fh_burgenland.bswe.algo.sorting.fileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {

    /**
     * Reads a file where numbers are separated by semicolons.
     * The file is expected to be located in the "src/main/resources" directory.
     * The method splits each line by semicolons and parses the resulting values as integers.
     *
     * @param fileName The name of the file to be read.
     * @return An ArrayList containing the integers read from the file.
     */
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

    /**
     * Reads a file line by line and parses each line as an integer.
     * The file is expected to be located in the "src/main/resources" directory.
     * Each line should contain one integer.
     *
     * @param fileName The name of the file to be read.
     * @return An ArrayList containing the integers read from each line of the file.
     */
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
