import java.util.Scanner;
// Rashid Ali
public class InfixToPostfix {

    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        //MyStack<Character> operatorStack = new MyStack<>(infixExpression.length());      //For Array ADT
        MyLLStack<Character> operatorStack = new MyLLStack<>();    //For Linked List ADT

        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty()) {
                    operatorStack.pop(); 
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses in the infix expression.");
                }
            } else {
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                throw new IllegalArgumentException("Mismatched parentheses in the infix expression.");
            }
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }
    public static double evaluatePostfix(String postfixExpression) {
        MyStack<Double> operandStack = new MyStack<>(postfixExpression.length());
        Scanner scanner = new Scanner(System.in);

        for (char c : postfixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                operandStack.push((double) Character.getNumericValue(c));
            } else if (Character.isLetter(c)) {
                System.out.print("Enter value for variable '" + c + "': ");
                double value = scanner.nextDouble();
                operandStack.push(value);
            } else if (isOperator(c)) {
                if (operandStack.size() < 2) {
                    scanner.close();
                    throw new IllegalArgumentException("Invalid postfix expression: Not enough operands for operator '" + c + "'.");
                }
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = performOperation(c, operand1, operand2);
                operandStack.push(result);
            }
        }

        scanner.close();

        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: More than one result remaining.");
        }

        return operandStack.pop();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '|':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '|' || c == '*' || c == '/';
    }

    private static double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '|':
                return operand1 + operand2;                
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

}
