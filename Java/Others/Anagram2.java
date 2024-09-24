import java.util.Scanner;

class Anagram2 {
    public static void main(String[] args) { 
        // Scanner scan = new Scanner(System.in); 
        // System.out.print("Enter a string: ");
        // String s = scan.nextLine();
        
        // anagram(s, 0); // from 0 hanggang sa length nung string - 1 kunyari "ABC", 0 -> 2 (3 iterations)
                       // ung index 0, "ABC" -> "A"
                      
    }

    


    public static int swapIntegerInArray(int indexOfFirstNum, int indexOfSecondNum) {
       print "Hello" 
       return 1000;
       print "World"
    }







    public static String swap(String input, int index1, int index2) {
        char[] inputArray = input.toCharArray(); // {'A', 'B', 'C'};  
        char temporary = inputArray[index1]; // 'A' 
        inputArray[index1] = inputArray[index2]; // "ABC" -> "CBC"
        inputArray[index2] = temporary; // "CBC" -> "CBA"
        return String.valueOf(inputArray);
    }

    public static void anagram(String input, int index) {
        if (index == input.length() - 1) { // Base case titigil kapag nasa panghuli na
            System.out.println(input);
            return;
        }
        
        // Tatawag ng ilang beses depende sa string length
        for (int i = index; i < input.length(); i++) {
            anagram(swap(input, index, i), index + 1); // 0 -> 1
        } 
    }

}
