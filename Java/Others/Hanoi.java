import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = scan.nextInt();
        solve(n);
    }

    static void solve(int n) {
        helper(n, 'A', 'B', 'C');
    }

    static void helper(int n, char source, char auxiliary, char destination) {
        if (n == 0) {
            return;
        }

        // STEP 1: Move n-1 disks from source to 2nd rod (auxiliary), turning the 3rd rod as (auxiliary)
        helper(n-1, source, destination, auxiliary);

        // STEP 2: Move largest disk to 3rd rod (destination)
        System.out.println("Moving disk from " + source + " to " + destination + " n value is: " + n);

        // // STEP 3: Move n-1 disks from 2nd rod to destination rod
        helper(n-1, auxiliary, source, destination);
    }
}
