package Homework.Homework1;
import java.util.Scanner;
public class IO {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1, num2;
        System.out.print("Enter an integer: ");
        num1 = Integer.parseInt(s.nextLine());
        System.out.print("Enter another integer: ");
        num2 = Integer.parseInt(s.nextLine());
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
