package me.ryandelap.implementations.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInsertionSort {

    @Test
    public void testInsertionSort() {
        int[] elements = {5, 1, 3, 4, 9, 1, 42, 5};
        InsertionSort.sort(elements);

        assertEquals(1, elements[0]);
        assertEquals(42, elements[elements.length - 1]);

    }
}
