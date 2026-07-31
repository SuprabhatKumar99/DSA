/* 
Largest & Second Largest Element

1. Find the Largest Element
    Approach 1 — Sort
    Approach 2 — Single Pass => Maintain: int largest = arr[0];

2. Second Largest Element
    Brute Force — Sort
    Two Passes


Core logic:
    if (x > largest) {
        secondLargest = largest;
        largest = x;
    } else if (x < largest && x > secondLargest) {
        secondLargest = x;
    }


This teaches an important programming principle: When updating related state, update values in an order that doesn't destroy information you still need.

Second Smallest
    The exact same idea works in reverse.
    Maintain: smallest & secondSmallest.


Interview Pattern

    This problem introduces a very useful pattern:
        Track the best and second-best values while scanning.

    You'll encounter variations such as:
        largest + second largest
        smallest + second smallest
        highest + second highest
        minimum + second minimum
        top two scores

Before sorting, ask:
    Can I maintain the required information during one traversal?
    Often the answer is yes.


| Approach             |         Time |           Space |
| -------------------- | ------------ | --------------- |
| Sorting              |  O(n log n)  | depends on sort |
| Two traversals       |        O(n)  |           O(1)  |
| Optimal one pass     |      O(n)    |         O(1)    |


Pattern to remember:
        For every x:

        x > largest ?
            ↓ yes
        second = largest
        largest = x

            ↓ no

        largest > x > second ?
            ↓ yes
        second = x

*/

public class Lesson10 {



    public static int findLargest(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        return max;
    }

    public static int secondLargest(int[] arr) {

        if (arr.length < 2) {
            throw new IllegalArgumentException(
                "At least two elements are required"
            );
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int x : arr) {

            if (x > largest) {

                secondLargest = largest;
                largest = x;

            } else if (x < largest && x > secondLargest) {

                secondLargest = x;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                "No distinct second largest element"
            );
        }

        return secondLargest;
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 1, 3, 0};
        
        int largest = findLargest(arr);

        System.out.println(largest);

        int second = secondLargest(arr);
        System.out.println(second);
    }
    
}
