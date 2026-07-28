import java.util.Arrays;

/**
 * 
 * Lesson5
 * What is sorting? => arrange in Ascending order.
 * 
 * Selection Sort => Find the smallest element from the unsorted part and place it at the beginning.
 * select the minimum.
 * 
 * outer loop goes to (n - 1) => swapping of element done heres
 * inner loop goes to n => finding of smallest term done here
 * Best case == Average Case == Worst Case ==> O(n^2)
 * Space complexity : O(1)
 * 
 * ##Select the minimum from the unsorted portion and swap it into the current position.
 */
public class Lesson5 {

    public static void selectionSort(int[] arr){
        
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {    
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
         
        }
    }
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}