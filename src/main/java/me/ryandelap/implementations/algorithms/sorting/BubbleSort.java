package me.ryandelap.implementations.algorithms.sorting;

public class BubbleSort {

    /**
     *
     * Runs in O(N^2) time.
     * @param arr the integer array to sort.
     */
    public static void sort(int[] arr) {
        int len = arr.length - 1;
        int temp;

        for(int j = 0; j < len; j++) {
            for (int i = 0; i < len; i++) {
                int value = arr[i];
                int next = arr[i + 1];
                if (value > next) {
                    temp = arr[i]; //Swap the values
                    arr[i] = next;
                    arr[i + 1] = temp;
                }
            }
            len--; //Decrement the length because the last element of the sorted array is always in the correct position.
        }
    }
}
