package me.ryandelap.implementations.algorithms.searching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBinarySearch {

    @Test
    public void testBinarySearch() {
        int[] elements = {1, 3, 4, 5, 13, 20, 25, 40, 44, 52, 53};
        int findOne = BinarySearch.search(elements, 1, 0, elements.length - 1);
        int findFiftyThree = BinarySearch.search(elements, 53, 0, elements.length - 1);
        int findTwenty = BinarySearch.search(elements, 20, 0, elements.length - 1);

        //Confirm indexes work.
        assertEquals(0, findOne);
        assertEquals(10, findFiftyThree);
        assertEquals(5, findTwenty);

    }
}
