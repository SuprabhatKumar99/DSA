/* 
Quick Sort
Choose a pivot → put smaller elements on its left and larger elements on its right → recursively sort both sides.

The important property is: left side <= pivot <= right side


Partitioning with Two Pointers

flow of quick sort
    Choose pivot
    ↓
    Partition
    ↓
    Pivot reaches correct position
    ↓
    Sort left
    ↓
    Sort right


There are three while loops in partition, their purposes are:
    (outer loop) 
    while #1
    
        (inner loop)
        while #2
        while #3

Interview-Level Mental Model

        QUICK SORT

       choose pivot
            ↓
          partition
         ↙         ↘
    <= pivot      > pivot
              ↓
  pivot reaches final position
             ↓
        quickSort(left)
             ↓
        quickSort(right)


*/

import java.util.Arrays;

public class Lesson9 {


    public static void quickSort(int[] arr, int low, int high){
        
        if(low >= high) return;

        int pivotIndex = partition(arr, low, high); // returns the index of the pivot element

        quickSort(arr, low, pivotIndex - 1); // left
        quickSort(arr, pivotIndex + 1, high); // right
    }

    public static int partition(int[] arr, int low, int high){
        
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) { //from begin to end of the array 
            
            while (left <= high && arr[left] <= pivot) {
                left++;
            }

            while (right > low && arr[right] > pivot) {
                right--;
            }

            if (left < right) { // swapping of element if condition is true
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        //swapping
        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;

        return right;
    }


    public static void main(String[] args) {
       int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
       
       quickSort(arr, 0, arr.length-1);

       System.out.println(Arrays.toString(arr));

       //output: [1, 2, 3, 4, 5, 6, 7, 9] 
    }
    
}
