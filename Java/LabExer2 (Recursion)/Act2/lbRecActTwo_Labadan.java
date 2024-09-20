import java.util.Scanner;

public class lbRecActTwo_Labadan {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String userResponse = "YES";
		System.out.println("\t    <====== TOWER OF HANOI ======>\n");
		System.out.print("\t    Enter the number of disks: ");
		int numberOfDisks = scan.nextInt();
		Hanoi puzzle = new Hanoi(numberOfDisks, 'J', 'O', 'Y');
		puzzle.solve();

		while (true){
			System.out.print("\n\t  Continue? (YES/NO): ");
			scan.nextLine();
			userResponse = scan.nextLine();
			if (userResponse.equalsIgnoreCase("YES")) {
				System.out.println("\n\t    <====== TOWER OF HANOI ======>\n");
				System.out.print("\t    Enter the number of disks: ");
				numberOfDisks = scan.nextInt();
				puzzle.reset(numberOfDisks);
				puzzle.solve();
				continue;
			}
			break;
		}

	}
}
