import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*I should make program input number n which will be size of an array*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(minMe(arr,n));
        System.out.println(avg(arr,n));
        if (isPrime(m)){
            System.out.println("Prime");
        }else{
            System.out.println("Composite");
        }
        System.out.println(factorial(m));
        System.out.println(Fib(m));
        System.out.println(aInPowerOfN(m,p));

        int l = sc.nextInt();
        int[] array=new int[l];
        String s = "123a12";
        too100( array, 0, 1 );
        tooWhat(array,0);
        System.out.println(isAllDigits(s, 0) ? "Yes" : "No");
        System.out.println(binomNotSchool(m, p));
        System.out.println(gcd(m,p));

    }
    /**
     * This method finds the minimum element in the given array.
     * It uses a for loop to iterate through the array.
     * O(n) linear time complexity.
     * The loop starts from index 1 (since min is initialized with arr[0]) and goes up to n.
     * @param arr The input array in which the minimum element is searched.
     * @param n The size of the array.
     * @return int The minimum element found in the array.
     */
    public static int minMe(int[] arr, int n) {
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
    /**
     * This method calculates the average of the elements in the given array.
     * It uses a for loop to iterate through the array and sum its elements.
     * O(n) linear time complexity.
     * The loop iterates from index 0 to n, adding each element to the sum.
     * @param arr The input array containing numerical values.
     * @param n The size of the array.
     * @return double The computed average of the array elements.
     */
    public static double avg(int[] arr, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum / n;
    }
    /**
     * This method checks whether a given number is prime.
     * It iterates from 2 to n-1, checking if n is divisible by any number.
     * O(n) linear time complexity.
     * If n is less than 2, it is not prime.
     * If n is divisible by any number in the range, it returns false.
     * @param n The number to check for primality.
     * @return boolean True if the number is prime, false otherwise.
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * This method calculates the factorial of a given number using recursion.
     * It multiplies the number by the factorial of (n-1) until n is less than 2.
     * O(n) linear time complexity.
     * If n is less than 2, it returns 1 as the base case.
     * @param n The number for which the factorial is computed.
     * @return int The factorial of the given number.
     */
    public static int factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    /**
     * This method calculates the nth Fibonacci number using recursion.
     * It follows the Fibonacci sequence where Fib(n) = Fib(n-1) + Fib(n-2).
     * O(2^n) exponential time complexity due to repeated calculations.
     * The base cases return n when n is 0 or 1.
     * @param n The position in the Fibonacci sequence.
     * @return int The Fibonacci number at position n.
     */
    public static int Fib(int n) {
        if(n == 1 || n == 0){
            return n;
        }
        return  Fib(n-1) + Fib(n-2);
    }
    /**
     * This method calculates the power of a number using recursion.
     * It follows the formula: n^p = n * n^(p-1).
     * O(p) linear time complexity.
     * The base case returns 1 when p is 0 (since any number to the power of 0 is 1).
     * @param n The base number.
     * @param p The exponent to which the base is raised.
     * @return int The result of n raised to the power of p.
     */
    public static int aInPowerOfN(int n, int p) {
        if (p == 0) {
            return 1;
        }
        return n * aInPowerOfN(n, p - 1);
    }
    /**
     * This method recursively fills an array with user input values.
     * It uses a Scanner to read input and assigns it to the array at index i.
     * O(n) linear time complexity.
     * The recursion continues until the index reaches the array length.
     * @param array The array to be filled with input values.
     * @param i The current index being assigned a value.
     * @param v An incrementing variable (not used in the logic).
     */
    private static void too100(int[] array, int i, int v) {
        if( i < array.length ) {
            Scanner sc=new Scanner(System.in);
            array[i] = sc.nextInt();
            too100( array,i+1, v+1 );
        }
    }
    /**
     * This method prints the elements of an array in reverse order using recursion.
     * It recursively calls itself before printing the current element.
     * O(n) linear time complexity.
     * The recursion continues until the index reaches the array length.
     * After recursion returns, the elements are printed in reverse order.
     * @param array The array containing the elements to print.
     * @param i The current index being processed.
     */
    private static void tooWhat(int[] array, int i) {
        if (i < array.length) {
            tooWhat(array, i + 1); // Recursive call before printing
            System.out.print(array[i] + " "); // Print after recursion returns
        }
    }
    /**
     * This method checks if a given string consists only of digit characters using recursion.
     * It verifies each character using Character.isDigit() and moves to the next index.
     * O(n) linear time complexity.
     * The base case returns true if all characters have been checked.
     * If a non-digit character is found, it returns false immediately.
     * @param s The input string to check.
     * @param i The current index being checked.
     * @return boolean True if all characters are digits, false otherwise.
     */
    private static boolean isAllDigits(String s, int i) {
        if (i == s.length()) {
            return true; // If we've checked all characters and found no non-digits
        }
        if (!Character.isDigit(s.charAt(i))) {
            return false; // If a non-digit is found
        }
        return isAllDigits(s, i + 1); // Recursive call to check the next character
    }
    /**
     * This method calculates the binomial coefficient C(n, k) using recursion.
     * It follows the formula: C(n, k) = C(n-1, k-1) + C(n-1, k).
     * O(2^n) exponential time complexity due to repeated calculations.
     * The base case returns 1 when k is 0 or k equals n (C(n, 0) = C(n, n) = 1).
     * @param n The total number of elements.
     * @param k The number of elements chosen.
     * @return int The computed binomial coefficient C(n, k).
     */
    private static int binomNotSchool(int n, int k) {
        if (k == 0 || k == n) {
            return 1; //C(n,0) = C(n,n) = 1
        }
        return binomNotSchool(n - 1, k - 1) + binomNotSchool(n - 1, k);
    }
    /**
     * This method calculates the greatest common divisor (GCD) of two numbers using recursion.
     * It follows the Euclidean Algorithm: GCD(a, b) = GCD(b, a % b).
     * O(log(min(a, b))) logarithmic time complexity.
     * The base case returns a when b is 0.
     * @param a The first number.
     * @param b The second number.
     * @return int The greatest common divisor of a and b.
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a; // Base case: if b is 0, return a
        }
        return gcd(b, a % b); // Recursive call using Euclidean Algorithm
    }
}