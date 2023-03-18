/**
 * Driver
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        System.out.println("How much can you spend?");
        Scanner scan = new Scanner(System.in);
        double total = scan.nextDouble();
        double sum = 0;
        int i = 0;
        ArrayList<Double> proportion = new ArrayList<Double>();
        System.out.println("enter your proportion of various expenses.");
        System.out.println("the system stops if proportion is over 100%");
        do {
            System.out.println("your proportion of expense " + (i + 1) + ": ");
            double value = scan.nextDouble();
            proportion.add(value);
            sum += proportion.get(i);
            i++;
        } while (sum <= 100);
        scan.close();
        if (sum > 100) {
            double cumulativeSum = 0.0;
            for (int j = 0; j < proportion.size() - 1; j++) {
                cumulativeSum += proportion.get(j);
            }
            proportion.set(proportion.size() - 1, 100.0 - cumulativeSum);
        }
        for (double value : proportion) {
            double expense = value * total / 100.0;
            System.out.println("your " + value + "% = $" + expense);
        }
    }
}