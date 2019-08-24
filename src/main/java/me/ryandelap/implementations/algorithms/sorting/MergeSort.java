package me.ryandelap.implementations.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    /**
     * Merge sort is very fast. Average run time of O(n*logn)
     * Classic divide and conquer problem.
     *
     * @param arr
     * @param n
     */
    public static void mergeSort(int[] arr, int n) {
        if(arr.length < 2) {
            return;
        }

        int pivot = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, pivot); //I hope this runs in O(N) time.
        int[] right = Arrays.copyOfRange(arr, pivot, arr.length); //This would be changed to a for loop to build these arrays if not.

        mergeSort(left, left.length);
        mergeSort(right, right.length);

        merge(arr, left, right);
    }

    //Requires that arr1 and arr2 are already sorted.
    public static void merge(int[] array, int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                array[k] = arr2[j];
                k++;
                j++;
            } else {
                array[k] = arr1[i];
                k++;
                i++;
            }
        }
        while (i < arr1.length) {
            array[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length) {
            array[k] = arr2[j];
            k++;
            j++;
        }
    }
}
