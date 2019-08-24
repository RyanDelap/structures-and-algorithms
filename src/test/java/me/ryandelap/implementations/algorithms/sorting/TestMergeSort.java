package me.ryandelap.implementations.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMergeSort {

    @Test
    public void testMergeSort() {
        int[] elements = {5, 1, 3, 4, 9, 1, 42, 5};
        MergeSort.mergeSort(elements, elements.length);

        assertEquals(1, elements[0]);
        assertEquals(42, elements[elements.length - 1]);

    }
}
