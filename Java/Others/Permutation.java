import java.util.Scanner;

public class Permutation {
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter n: "); // n = limang upuan 5 seats
		int n = scan.nextInt();
		System.out.print("Enter r: "); // r = 3 tao, 
		int r = scan.nextInt();
                                    //  nPr
		System.out.printf("Permutation %dP%d = %d\n", n, r, permutation(n, r));


        // _ _ _ _ _

	}

	/*
	       PERMUTATION FORMULA:
			           n!
			 nPr  =  -----
			         (n-r)!
	*/
	public static int permutation(int n, int r) {
		return (factorial(n) / factorial(n - r));
	}

	public static int factorial(int n) {
		if (n <= 0) { // base case
			return 1;
		}
		return n * factorial(n - 1);
	}
}
