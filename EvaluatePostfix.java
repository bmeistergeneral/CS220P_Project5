import java.util.Stack;
public class EvaluatePostfix {
    public static int evaluate(String exp) {
        // Creates a new stack
        Stack<Integer> stack = new Stack<>();
        // Creates a loop that iterates through each character
        // of the postfix expression and detects if it is an
        // operator or an operand.
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            // if it's a number, push onto stack, else, remove the first
            // two operands and combine it with the operator and
            // then push the result on the stack. Repeat process until
            // final result is reached and print the result.
            if (Character.isDigit(ch)) {
            stack.push(ch - '0');
            } else {
            int value1 = stack.pop();
            int value2 = stack.pop();
            switch (ch) {
                // Different cases for operators.
                case '+':
                    stack.push(value2 + value1);
                    break;
                case '-':
                    stack.push(value2 - value1);
                    break;
                case '*':
                    stack.push(value2 * value1);
                    break;
                case '/':
                    stack.push(value2 / value1);
                    break;
                case '%':
                    stack.push(value2 % value1);
            }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        // This can be any postfix expression and be changed
        // to be a random postfix expression generator, but
        // for my purposes I will give one here and test for multiple.
        String exp = "47*28-+";
        System.out.println("Postfix evaluation: " + evaluate(exp));
    }
}
