package Examples;

import java.util.Arrays;

public class AllSortsOf {
    public static void main(String[] args) {
        int[] array = { 2, 4, 1, 8, 3, 5, 9, 7, 6, 10 };
        bubbleSort(array);
        selectionSort(array);
        selectionSort2(array);
        InsertionSort(array);

    }

    static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(array));

    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index_terkecil = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index_terkecil]) {
                    // swap
                    index_terkecil = j;

                }

            }
            // swap
            int temp = arr[index_terkecil];
            arr[index_terkecil] = arr[i];
            arr[i] = temp;

        }
        System.out.println(Arrays.toString(arr));

    }

    static void selectionSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index_terkecil = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index_terkecil]) {
                    // swap
                    index_terkecil = j;

                }

            }
            // swap
            int temp = arr[index_terkecil];
            arr[index_terkecil] = arr[i];
            arr[i] = temp;

        }
        System.out.println(Arrays.toString(arr));

    }

    static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int data = arr[i];
            while (j >= 0 && arr[j] > data) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = data;

        }
        System.out.println(Arrays.toString(arr));

    }
}
