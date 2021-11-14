package Task2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.startApplication();
    }

    public void startApplication() {
        Scanner scanner = new Scanner(System.in);

        int num1 = getInt(scanner);
        int num2 = getInt(scanner);
        char operation = getOperation(scanner);
        int result = calc(num1, num2, operation);
        System.out.println("The result of the operation: " + num1 + " " + operation + " " + num2 + " = " + result);
    }

    public int getInt(Scanner scanner) {
        System.out.println("Enter the number:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("You made a mistake entering the number. Try again.");
            scanner.next();//recursion
            num = getInt(scanner);
        }
        return num;
    }

    public char getOperation(Scanner scanner) {
        System.out.println("Enter the operation: (the first character will be used)");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("You made a mistake entering the operation. Try again.");
            scanner.next();//recursion
            operation = getOperation(scanner);
        }
        if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            System.out.println("Operation not recognized.");
            operation = getOperation(scanner);
        }
        return operation;
    }

    public int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            default:
                result = num1 / num2;
        }
        return result;
    }

}