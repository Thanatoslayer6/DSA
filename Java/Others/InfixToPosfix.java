import java.util.Stack;
import java.util.Scanner;

public class InfixToPosfix {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Stack<Character> myS = new Stack<>();

        String postfix = "";
        System.out.print("Enter an infix expression: ");
        String exp = scan.nextLine();
        
        // e.g '1 + 2 * 5' 
        for (char c : exp.toCharArray()) {
            if (c == ' ') continue;

            if (isOperator(c)) { // +, -, /, *
                while (!myS.isEmpty() && precedence(myS.peek()) >= precedence(c)) {
                    postfix += myS.pop();
                }
                myS.push(c);
                continue;
            } 

            if (c == '(') { // Left parenthesis
                myS.push(c);
                continue;
            }

            if (c == ')') { // Right parenthesis
                while (true) {
                    char symbol = myS.pop();
                    if (symbol == '(') break;
                    postfix += symbol;
                }
                continue;
            }

            postfix += c;
        }

        while(!myS.isEmpty()) {
            postfix += myS.pop();
        }
        
        System.out.println(postfix);
    }

    public static boolean isOperator(char symbol) {
        if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' || symbol == '^') {
            return true;
        }
        return false;
    }

    public static int precedence(char symbol) {
        switch(symbol) {
            case '^':
                return 3;
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}
