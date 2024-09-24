import java.util.Scanner;

public class Fibonacci {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        System.out.printf("The nth term is: %d\n", fibterm(n));
        System.out.printf("The fib sum is: %d\n", fibsum(n));
    }
    
    // 0, 1, 1, 2, 3, 5, 8, 13
    public static int fibterm(int n) {
        if (n == 0) { // Base cases
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return fibterm(n - 1) + fibterm(n - 2);
    }

    public static int fibsum(int n) {
        if (n == 0)
            return 0; 

        return fibterm(n) + fibsum(n - 1);
    }
}

