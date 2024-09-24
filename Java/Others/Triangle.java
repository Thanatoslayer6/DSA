import java.util.Scanner;

public class Triangle {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scan.nextInt();
        System.out.println("The sum is: " + triangle(n, 0));
    }

    public static int triangle(int n, int current) {
        if (n == 0) 
            return 0;
        return n + triangle(n - 1);
    }

}
