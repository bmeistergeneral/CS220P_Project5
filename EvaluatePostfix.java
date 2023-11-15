import java.util.Stack;
public class EvaluatePostfix {
    public static int evaluate(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch)) {
            stack.push(ch - '0');
            } else {
            int value1 = stack.pop();
            int value2 = stack.pop();
            switch (ch) {
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
        String exp = "231*+9-";
        System.out.println("Postfix evaluation: " + evaluate(exp));
    }
}
