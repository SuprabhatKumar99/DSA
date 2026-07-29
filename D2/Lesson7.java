import java.util.Arrays;

/**
 * 
 * Lesson7
 * 
 * Insertion Sort: take an element and insert it into its correct position in the sorted portion.
 * 
 * outer for loop goes to n
 * inner while loop goes with condition `j > 0 && arr[j - 1] > arr[j]`
 * 
 * 
 * 
 Case         Complexity 
 Best           O(n) 
 Average       O(n²) 
 Worst         O(n²) 
 Extra Space    O(1) 

 */

public class Lesson7 {

    public static void insertionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {14, 9, 15, 12, 6, 8, 13}; 
        
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

/*
Instead of repeatedly swapping, save the current element and shift larger elements right.
public static void insertionSort(int[] arr) {

    for (int i = 1; i < arr.length; i++) {

        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {

            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}

*/