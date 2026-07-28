import java.util.Arrays;

/**
 * 
 * Lesson6
 * 
 * Bubble Sort: Compare adjacent elements and swap them if they are in the wrong order.
 * ==> push the maximum to the end.
 * 
 * Algorithm:- Repeat n-1 times: => Compare adjacent elements => if left > right: => swap them 
 * 
 * outer loop goes to n - 1 => 
 * inner loop goes to n - i - 1  => condition checking and swapping done here 
 * 
 * n-i-1 => we don't need to compare the sorted portion again.
 * j < n - i - 1 => The searchable area becomes smaller after every pass.
 * 
 * Complexity: 
     Case             Complexity 
     
     Best, optimized    O(n)
     Average           O(n²) 
     Worst             O(n²) 
     Extra space        O(1) 
 

 */
public class Lesson6 {

    public static void bubbleSort(int[] arr){
        //
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //
    }


    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
    
}
