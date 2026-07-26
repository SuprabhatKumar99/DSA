/*
 * Base Case - Every recursive function MUST have a base case.
 * 
 * Recursive Relation - How does the current problem reduce to a smaller one?
 * 
 * Progress - Does each recursive call move closer to the base case?
 */

public class Lesson3 {

    //print 1 to N recursively
    public static int print1ToN(int i, int n){

        if (i > n) {
            return 0; 
        }

        System.out.println(i);
        return print1ToN(i+1, n);
    }
    
    //print N to 1 recursively
    public static int printNTo1(int n){
         if (n <= 0) {
            return 0;
        }

        System.out.print(n + " ");
        return print1ToN(n - 1);
    }

    //sum of first 100 natural number
    public static int sumFirst(int n){
        
        if(n <= 0){
            return 0;
        }

        return n + sumFirst(n-1);
    }

    //factorial recursively
    public static int factorial(int n){

        if(n <= 0 || n == 1){
            return 1;
        }

        return n * factorial(n - 1);
    }

    //reverse array recursively 
    public static void reverse(int[] arr, int left, int right){
        
        if (left >= right) {
            return ;
        }

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left+1, right-1);
    }

    //
    public static boolean palindrome(String str, int left, int right){
        
        if(left >= right){
            return true;
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return palindrome(str, left+1, right-1);

    }

    public static int fibo(int n){
        if(n <= 1){
            return n;
        }

        return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) {
        print1ToN(1,5);
        System.out.println("Sum of first 100 natural number: " + sumFirst(100));
        System.out.println("Factorial of 7 is " + factorial(7));

        int[] arr = {1,35,5,6,4};
        reverse(arr, 0, arr.length-1);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        String s = "LEVEL";
        System.out.println("Given string '"+s+"' is palindrome: " + palindrome(s, 0, s.length()-1));
    
        System.out.println(fibo(7));
    }
}
