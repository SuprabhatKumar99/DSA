/* 
Merge Sort

Merge Sort has two major operations: Divide → Merge

We repeatedly divide the array into halves =>
A single-element array is automatically sorted =>
Then we start merging them in sorted order.


Merge Sort follows a general algorithmic strategy called Divide and Conquer.

                        Problem
                            ↓
                        Divide into smaller problems
                            ↓
                        Solve smaller problems
                            ↓
                        Combine their solutions

For Merge Sort:
DIVIDE
   ↓
Sort left half
   ↓
Sort right half
   ↓
MERGE both sorted halves

working
mergeSort(arr, low, high);//call
First calculate the middle: int mid = (low + high) / 2;
Then recursively sort: mergeSort(arr, low, mid); => mergeSort(arr, mid + 1, high); => merge(arr, low, mid, high);


base case (recursion stop condition): if (low >= high) return; 
Because when: low == high => there is only one element. And a one-element array is already sorted.


The Hard Part — Merge
There are three while loops, their purposes are:
    while #1 =>Compare left and right

    while #2 => Copy leftover left elements

    while #3 => Copy leftover right elements


 Case        Time  
 Best     O(n log n) 
 Average  O(n log n) 
 Worst    O(n log n) 

 Space Complexity = O(n)

 Why <= Here? => if (arr[left] <= arr[right]) rather than simply: arr[left] < arr[right]
 When the values are equal, choosing the left element first helps preserve their original relative ordering.
This property makes standard Merge Sort: Stable


flow of merge sort
    mergeSort(low, high)
            ↓
    low >= high ?
            ↓ yes
        return
            ↓ no
    find mid
            ↓
    mergeSort(low, mid)
            ↓
    mergeSort(mid+1, high)
            ↓
    merge(left, right)

Why can't we simply merge two array using the two-pointer merge procedure?
Because the two halves must already be sorted. That's why recursion sorts each half before merge() is called.
*/

import java.util.Arrays;

public class Lesson8 {
    
    public static void mergeSort(int[] arr, int low, int high){

        if(low >= high) return;
        
        int mid = low + (high - low)/2;

        mergeSort(arr, low, mid); //left
        mergeSort(arr, mid+1, high); //right
        merge(arr, low, mid, high); //compare and merge

    }

    public static void merge(int[] arr, int low, int mid, int high){

        int[] temp = new int[high - low + 1];

        int left = low; //left pointer
        int right = mid + 1; //right pointer
        int index = 0; //use to put value in temp array

        //while #1
        while (left <= mid && right <= high) { //both left and right arrays start to their end 
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++]; //if element from left array is small then put it to temp 
            } else {
                temp[index++] = arr[right++]; //if element from right array is small then put it to temp
            }
        }

        //while #2 copy leftover left element
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        //while #3 copy leftover right element
        while (right <= high) {
            temp[index++] = arr[right++];
        }

        //returning the updated array
        for (int i = 0; i < temp.length; i++) {
            arr[low+i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6};
        
        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));

        //output: [1, 1, 2, 2, 3, 4, 5, 6]
    }
}
