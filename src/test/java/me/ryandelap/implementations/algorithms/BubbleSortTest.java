package me.ryandelap.implementations.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {

        int[] testData = {5, 4, 1, 2, 3};
        BubbleSort.sort(testData);

        assertEquals(1, testData[0]);
        assertEquals(5, testData[4]);
    }
}
