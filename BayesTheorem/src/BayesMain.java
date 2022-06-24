//P(A|B) = P(B|A)*P(A)/P(B)

import java.text.DecimalFormat;
import java.util.Scanner;

public class BayesMain {

    public static void main(String args[]) {

        Scanner BayesScan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");

        System.out.println("What percent of people have the disease and test positive for it?");
        double HaveAndPos = BayesScan.nextDouble() / 100;

        System.out.println("What percent of people do not have the disease and test negative for it?" );
        double NotHaveAndNeg = BayesScan.nextDouble() / 100;

        System.out.println("What is the ratio of people who have this disease?");
        double HaveRatio = BayesScan.nextDouble();

        double x = 1 - HaveRatio;
        double y = 1 - HaveAndPos;
        double z = 1 - NotHaveAndNeg;

        double outcome1 = (HaveAndPos * HaveRatio) / (HaveAndPos * HaveRatio + z * x) * 100;
        double outcome2 = (NotHaveAndNeg * x) / (y * HaveRatio + NotHaveAndNeg * x) * 100;

        System.out.println("False Positive: " + df.format(100 - outcome1) + "%");
        System.out.println("True Positive: " + df.format(outcome1) + "%");
        System.out.println("False Negative: " + df.format(100 - outcome2) + "%");
        System.out.println("True Negative: " + df.format(outcome2) + "%");

    }
}
