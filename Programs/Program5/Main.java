import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = s.nextLine();
        String postfix = infixToPostfix(infix);
        int output = evalPostfix(postfix);

        System.out.println("Summary\n-------");
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Result: " + output);
    }

    /**
     * Gets the infix priority of the given operator
     * @param c a given operator
     * @return infix priority of the char (1, 2, 3, 4, or 0)
     */
    public static int getInfixPriority(char c){
        switch (c){
            case '-', '+':
                return 1;
            case '/', '*':
                return 2;
            case '^':
                return 3;
            case '(':
                return 4;
            default:
                return 0;
        }
    }

    /**
     * Gets the operator stack priority of the given operator
     * @param c a given operator
     * @return 1, 2, 0
     */
    public static int getStackPriority(char c){
        switch (c){
            case '-', '+':
                return 1;
            case '/', '*', '^':
                return 2;
            default: 
                return 0;
        }
    }
    /**
     * Returns if the given charachter is a digit
     * @param c a given char
     * @return boolean
     */
    public static boolean isOperand(char c){
        return Character.isDigit(c);
    }
    /**
     * Takes two numbers and performs an operation with them based on the given operator
     * @param operator The operation that will be performed
     * @param a one number in the operation to be preformed
     * @param b one number in the operation to be preformed
     * @return int The result of the given operation
     */
    public static int eval(char operator, int a, int b){
        switch (operator){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            case '*':
                return a * b;
            case '^':
                return (int)Math.pow(a, b);
            default:
                return -1;
        }
    }

    /**
     * Converts an infix String into a postfix String
     * @param infixString the given infix String 
     * @return String the resulting postfix String 
     */
    public static String infixToPostfix(String infixString){
        // Declare and init all variables
        Queue<Character> postfixQueue = new Queue<>();
        Stack<Character> operatorStack = new Stack<>();
        Queue<Character> infixQueue = new Queue<>();

        // Enqueue each charachter from the infixString to the infixQueue
        for (char c : infixString.toCharArray()) {
            infixQueue.enqueue(c);
        }

        // Process the infixQueue
        while(!infixQueue.isEmpty()){
            // Grabs the new character
            char token = infixQueue.dequeue();

            // Process the operands
            if (isOperand(token)){
                postfixQueue.enqueue(token);
            } 
            // process parenthesis
            else if (token == ')') {
                char operator = operatorStack.pop();
                while (operator != '('){
                    postfixQueue.enqueue(operator);
                    operator = operatorStack.pop();
                }
            } 
            // Process the operators
            else { 
                // handle the operators already in the operatorStack
                if (!operatorStack.isEmpty()){
                    char operator = operatorStack.peek();

                    // move operators with high priority into our postfixQueue
                    while(getStackPriority(operator) >= getInfixPriority(token)){
                        operator = operatorStack.pop();
                        postfixQueue.enqueue(operator);

                        // are there more operators in the operatorStack?
                        if (operatorStack.isEmpty()){
                            break; // no? break out
                        } 
                        operator = operatorStack.peek(); // yes? grab it
                    }
                }
                //push new operator
                operatorStack.push(token);
            }
        }

        // Unload the operatorStack onto the postfixQueue
        while(!operatorStack.isEmpty()){
            char operator = operatorStack.pop();
            postfixQueue.enqueue(operator);
        }

        //transfer the postfixQueue contents into a string
        String postfix = "";
        while(!postfixQueue.isEmpty()){
            postfix += postfixQueue.dequeue();
        }

        // return the postfix string
        return postfix;
    }

    /**
     * Returns the evaluated value of the given postfix String
     * @param postfixString a postfix string
     * @return int the result of the given postfix string
     */
    public static int evalPostfix(String postfixString){
        // Declare and init variables
        Queue<Character> postfixQueue = new Queue<>();
        Stack<Integer> evalStack = new Stack<>();
        int finalResult;

        // put each character into postfixQueue
        for (char c : postfixString.toCharArray()) {
            postfixQueue.enqueue(c);
        }

        // process the postfixQueue
        while(!postfixQueue.isEmpty()){
            char token = postfixQueue.dequeue();

            //if token is a digit, put it on the evalStack
            if(isOperand(token)){
                evalStack.push(token - '0');
            }
            // otherwise, evaluate the sub-expression and push
            // the answer to the evalStack 
            else {
                int a = evalStack.pop();
                int b = evalStack.pop();
                int answer = eval(token, b, a);
                evalStack.push(answer);
            }
        }

        // if evalStack is not empty after processing everything, then
        // return the final answer stored at the top
        if(!evalStack.isEmpty()){
            finalResult = evalStack.pop();
            return finalResult;
        } else {
            return -1;
        }
    }
}
