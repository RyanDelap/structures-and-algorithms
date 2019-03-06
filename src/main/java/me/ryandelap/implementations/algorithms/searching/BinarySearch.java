package me.ryandelap.implementations.algorithms.searching;

import java.util.Arrays;

public class BinarySearch {
    /**
     * Runtime: O(logn)
     * Binary search only works on a sorted array.
     * Binary search works by splitting the array over and over again by the midpoint element until we find what we are searching for.
     *
     *
     * @param arr The array to search
     * @param element The element we want to find.
     */
    public static int search(int[] arr, int element, int left, int right) {
        int midpoint = (left + right) / 2; //Java rounds down by default.
        int midpointElement = arr[midpoint];

        if(midpointElement == element) { //Base case
            return midpoint;
        } else if (midpointElement > element){
            return search(arr, element, left, midpoint - 1);
        } else {
            return search(arr, element, midpoint + 1, right);
        }
    }
}
