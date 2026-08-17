/*

Left Rotate Array by One & D places

Left Rotate by One Place = [1,2,3,4,5] => [2,3,4,5,1]

Complexity => Time: O(n) | Space: O(1)

Left Rotate by D Places
    Brute Force Approach
    Store the first D elements.
    Shift remaining elements
    Copy stored values

*/

import java.util.Arrays;

public class Lesson13 {

    public static void leftRotateByOne(int[] arr){

        int first = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }

        arr[n-1] = first;
        
    }

    public static void leftRotate(int[] arr,int d){

        int n=arr.length;

        d=d%n;

        reverse(arr,0,d-1);

        reverse(arr,d,n-1);

        reverse(arr,0,n-1);
    }

    public static void reverse(
            int[] arr,
            int left,
            int right){

        while(left<right){

            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        leftRotateByOne(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
