package Homework.Homework1;

public class Constants {
    public static final double SALES_TAX = .11;
    public static void main(String[] args) {
        double subtotal = 5.25;
        double total = subtotal * (1 + SALES_TAX);
    }
}
