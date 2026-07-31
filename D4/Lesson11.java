/*

Check if an Array is Sorted

To check if an array is sorted, you only need to compare adjacent elements.

    Approach 1 — Brute Force (Not Recommended)
        Compare every element with every other element after it.
        Complexity: Time: O(n²), Space: O(1) => inefficient

    Optimal Approach : Traverse once. 
        If any element is greater than the next element: arr[i] > arr[i+1]
        the array is not sorted. Otherwise, it is sorted.
        Complexity:
            We visit every element once.
            Therefore:
                Time: O(n)
                Space: O(1)

This is the optimal solution
    

Why arr.length - 1?
    Because inside the loop we access: arr[i + 1] => becomes: arr[arr.length]
    which is outside the array and causes: ArrayIndexOutOfBoundsException

Descending Order


Strictly Increasing vs Non-Decreasing
    Strictly Increasing
        Condition: arr[i] < arr[i+1], Duplicates are not allowed.

    Non-Decreasing
        Duplicates are allowed.
        Condition: arr[i] <= arr[i+1]

    
Edge Cases 
    Single Element: already sorted return true
    Empty Array: Also considered sorted, return true
    All Equal Elements: No adjacent element is greater than the next, return true


Interview Insight
    Whenever you need to verify a sorted array, remember:
        Sorting is a local property. If every adjacent pair is in the correct order, the entire array is in order.

    This pattern appears in many advanced problems, such as:
        Detecting the first inversion
        Finding the rotation point in a rotated sorted array
        Checking whether an array can be made sorted with one swap

Summary: Check Sorted Array

    Traverse once
        ↓
    Compare adjacent elements

    arr[i] > arr[i+1] ?
        ↓
        Yes
        ↓
    Return false

    Otherwise
        ↓
    Return true
*/

public class Lesson11 {
    
    public static void isSorted(int[] arr){
        boolean flag = false;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("Not Sorted");
        } else {
            System.out.println("Sorted");
        }
    }

    public static void isDescending(int[] arr){
        boolean flag = false;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i+1]) {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("Not descending");
        } else {
            System.out.println("Descending");
        }
    }

    public static void main(String[] args) {
        
        int[] arr = {1,3,5,7,4};
        int[] sArr = {1, 2, 3, 4, 5};

        int[] dArr = {5,4,3,2,1};

        isSorted(arr);
        isSorted(sArr);

        isDescending(arr);
        isDescending(dArr);

    }
}
