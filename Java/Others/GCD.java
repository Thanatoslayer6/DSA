import java.util.Scanner;

public class GCD {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = scan.nextInt();
		System.out.print("Enter second number: ");
		int num2 = scan.nextInt();
		System.out.println("The GCD IS: " + gcd(num1, num2));
	}

    // 14, 28
	// 12, 6
	// gcd is 6
    // num1, num2
    // (12, 6)
    //  num1 = 12
    //  num2 = 6
    //     -> (6, 12 % 6) = (6, 0)
    //                      num1 = 6
    //                      num2 = 0
    //                        --> return num1 = return 6
    

   // (6, 12) 
   // num1 = 6
   // num2 = 12
   //       ----> (12, 6 % 12) = (12, 6)
   //                             
	public static int gcd(int num1, int num2) {
		// base case:
        if (num2 == 0) {

        }
        // if (num2 != 0) {
        //     return gcd(num2, num1 % num2);
        // }
        // return num1;
	}
}
