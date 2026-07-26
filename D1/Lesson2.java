import java.math.*;

public class Lesson2 {
    
    public static void countDigit(int num){
        int count = 0;
        int original = num;
        while (num > 0) {
            int digit = num%10;

            count++;

            num = num/10;
        }

        System.out.println("Count of the digit "+ original +" is: "+ count);
    }

    public static void reverse(int num){
        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num%10;
            reverse = reverse*10 + digit;
            num /= 10;
        }

        System.out.println("Reverse of the given number " + original + "is " + reverse);        
    }

    public static void isPalindrome(int num){
        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse*10 + digit;
            num /= 10;
        }

        if (original == reverse) {
            System.out.println("Given number "+ original +" is palindrome");
        }else{
            System.out.println("Given number "+ original +" is not palindrome");
        }
    }

    public static void isArmstrong(int num){
        int original = num;
        int length = String.valueOf(num).length();
        int armstrong = 0;

        while (num > 0) {
            int digit = num % 10;
            armstrong += (int)Math.pow(digit, length);
            num /= 10;
        }

        if (original == armstrong) {
            System.out.println("Given number "+ original +" is ArmStrong");
        } else {
            System.out.println("Given number "+ original +" is not ArmStrong");
        }
    }

    public static void printDivisor(int num){
        
        System.out.print("Divisor of " + num + " is ");

        for (int i = 1; i*i <= num; i++) {
            if (num%i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void isPrime(int num){

        boolean flag = true;

        if (num <= 1) {
            System.out.println("Not Prime");
        }

        for (int i = 2; i*i <= num ; i++) {
            if (num%i == 0) {
                flag = false;
                System.out.println("Not Prime");
            }
        }

        if (flag) {
            System.out.println("Prime Number");
        }
    }

    public static void gcd(int a, int b){
        //gcd(a, b) = gcd(b, a%b) //a>b
        int num1 = a;
        int num2 = b;

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        System.out.println("GCD of " + num1 + " & " + num2 + " is " + a);
    }
    
    public static void main(String[] args) {
        countDigit(123456);
        reverse(9876);
        isPalindrome(1221);
        isPalindrome(124521);
        isArmstrong(153);
        printDivisor(24);
        System.out.println();
        isPrime(21);
        isPrime(11);
        gcd(52, 10);
    }
}
