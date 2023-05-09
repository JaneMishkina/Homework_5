
//  * Реализовать алгоритм пирамидальной сортировки (HeapSort).

import java.util.Arrays;
import java.util.Random;

public class Example_3 {

    private static int[] makeRandomArray(int[] array){
        Random rd = new Random(); 
        for (int i = 0; i < array.length; i++) {
           array[i] = rd.nextInt(50); 
        }
        return array;
    }
    private static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int i, int n) {
        int l = i *2 + 1;
        int r = i * 2 + 2;
        int largest = i;

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, n);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        makeRandomArray(arr);
        System.out.printf("\nИсходный массив:\n%s", Arrays.toString(arr));

        heapSort(arr);
        System.out.printf("\nHeapSort:\n%s\n", Arrays.toString(arr));
}
}
