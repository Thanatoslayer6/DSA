import java.util.Scanner;

public class NumberToWords {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int userInput = scan.nextInt();
    if (userInput < 0 || userInput > 99999) {
        System.out.println("Please enter integer values in the range of 0-99000");
        return;
    }
    // First we make these two necessary array
	String ones[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
						 "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
	String tens[] = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
    //char[] userInputInChars = String.valueOf(userInput).toCharArray();
    // 9, 000
    //String hundredsPlace = ones[userInput / 100] + " hundred";
    //String tensPlace = tens[userInput / 1000];
    String result = "";
    int tenThousandsPlace = (userInput % 100000) / 10000;
    int thousandsPlace = (userInput % 10000) / 1000;
    int hundredsPlace = (userInput % 1000) / 100;
    int tensPlace = (userInput % 100) / 10;
    int onesPlace = (userInput % 10);
    //System.out.println((userInput % 100000) / 10000); // Ten thousands place
    //System.out.println((userInput % 10000) / 1000); // Thousands place
	//System.out.println((userInput % 1000) / 100); // Hundreds place
	//System.out.println((userInput % 100) / 10); // Tens place
	//System.out.println((userInput % 10)); // Ones
	if (tenThousandsPlace > 0) {
		result += tens[tenThousandsPlace];
	}
	if (thousandsPlace > 0) {
		result += ones[thousandsPlace];
		result += " thousand ";
	}

	if (hundredsPlace > 0) {
		result += ones[hundredsPlace] + " hundred ";
		if (tensPlace > 0) {
			result += tens[tensPlace];
		}
		if (onesPlace > 0) {
			result += ones[onesPlace];
		}
	} else {
		//System.out.println(10 + onesPlace);
		result += ones[10 + onesPlace];
	}

	System.out.println(result);
  }
}