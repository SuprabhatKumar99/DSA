/* 
Remove Duplicates from Sorted Array

The pattern will be reused in many problems like:
    Remove duplicates
    Move zeros
    Merge sorted arrays
    Remove elements
    Partition arrays

Important Observation 
    Notice the array is already sorted. [1,1,2,2,2,3,3,4] All duplicates are adjacent.
    This is the key reason we can solve it efficiently.
    If the array were unsorted: [2,1,4,2,3,1], duplicates could appear anywhere.


Brute Force Approach
    Use a HashSet => Then copy elements back => Works, but the problem asks us to modify the array in-place.
    Complexity => Time: O(n), Space: O(n)

Optimal Approach — Two Pointers
    Use two pointers.
        i → last unique element
        j → current element
    Time Complexity: O(n)
    Space Complexity: O(1)

    Initial: i = 0 & j = 1
    Compare: arr[i] == arr[j] => Duplicate. => Ignore.
    => Move only j. => Found a new unique element.
    => Move i. => Now: i increase, Copy: arr[i] = arr[j];
Pattern: Two Pointers

        Slow Pointer
            ↓
        Unique Elements

        Fast Pointer
            ↓
        Scans entire array
            ↓
        New element?
            ↓
        Move slow pointer
              ↓
            Copy

Interview Insight
Pattern:
        Slow Pointer
        ↓
        Unique Part
        ↓
        Fast Pointer scans
        0 1 2 2 3 3 4
        i
        j →
        Whenever
            new value found
            i++
        copy
*/

public class Lesson12 {
    
    public static int removeDuplicate(int[] arr){

        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {

        int arr[]={0,0,1,1,1,2,2,3,3,4};

        int n = removeDuplicate(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
