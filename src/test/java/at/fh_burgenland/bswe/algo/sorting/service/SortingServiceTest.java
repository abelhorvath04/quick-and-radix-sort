package at.fh_burgenland.bswe.algo.sorting.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingServiceTest {
    private final SortingService sortingService = new SortingService();
    private final FileReaderForTesting fileReaderForTesting = new FileReaderForTesting();

    @Test
    void handleNonExistingFile() {
        ArrayList<Integer> emptyList = new ArrayList<>();
        ArrayList<Integer> listFromEmptyFile = sortingService.getNumbersLineByLine("nonExists");
        assertEquals(emptyList, listFromEmptyFile);
    }
    @Test
    void getNumbersFromFileBySemicolon() {
        ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(123,321,234));
        ArrayList<Integer> actualList = fileReaderForTesting.fileReaderBySemicolon("numbersSemicolon.txt");
        assertEquals(expectedList, actualList);
    }

    @Test
    void getNumbersLineByLine() {
        ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(123,321,234));
        ArrayList<Integer> actualList = fileReaderForTesting.fileReaderBySemicolon("numbersLineByLine.txt");
        assertEquals(expectedList, actualList);
    }

    @Test
    void isSortedTest() {
        ArrayList<Integer> alreadySortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertTrue(sortingService.isSorted(alreadySortedList));
    }

    @Test
    void isEmptyList() {
        ArrayList<Integer> emptyList = new ArrayList<>();
        assertTrue(sortingService.checkEdgeCases(emptyList));
    }

    @Test
    void listHasOnlyOneElement() {
        ArrayList<Integer> oneElementList = new ArrayList<>();
        oneElementList.add(1);
        assertTrue(sortingService.checkEdgeCases(oneElementList));
    }

    @Test
    void listWithDuplicatedElementForQuickSort() {
        ArrayList<Integer> listWithDuplicatedElement = new ArrayList<>(Arrays.asList(1,3,3,2));
        ArrayList<Integer> sortedListWithDuplicatedElement = new ArrayList<>(Arrays.asList(1,2,3,3));
        ArrayList<Integer> sortedList = sortingService.sortNumbers("quick", listWithDuplicatedElement);
        assertEquals(sortedListWithDuplicatedElement, sortedList);
    }

    @Test
    void listWithDuplicatedElementForRadixSort() {
        ArrayList<Integer> listWithDuplicatedElement = new ArrayList<>(Arrays.asList(1,3,3,2));
        ArrayList<Integer> sortedListWithDuplicatedElement = new ArrayList<>(Arrays.asList(1,2,3,3));
        ArrayList<Integer> sortedList = sortingService.sortNumbers("radix", listWithDuplicatedElement);
        assertEquals(sortedListWithDuplicatedElement, sortedList);
    }

    @Test
    void reversedSortListWithQuickSort() {
        ArrayList<Integer> reversedSortList = new ArrayList<>(Arrays.asList(3,2,1));
        ArrayList<Integer> sortedListForTest = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> sortedList = sortingService.sortNumbers("quick", reversedSortList);
        assertEquals(sortedListForTest, sortedList);
    }

    @Test
    void reversedSortListWithRadixSort() {
        ArrayList<Integer> reversedSortList = new ArrayList<>(Arrays.asList(3,2,1));
        ArrayList<Integer> sortedListForTest = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> sortedList = sortingService.sortNumbers("radix", reversedSortList);
        assertEquals(sortedListForTest, sortedList);
    }
}