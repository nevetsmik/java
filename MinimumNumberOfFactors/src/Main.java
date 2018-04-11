/*
Given a number you need to output the minimum number of factors needed to represent that number such that none of the
factors is divisible by a perfect square.

getMinNumFactors(8) == 3

Factors of 8 are (2, 2, 2), (4, 2). 4 is divisible by 4, a perfect square, so (4, 2) is not answer leaving (2, 2, 2) as
the only answer.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static double getMinNumFactors(int num) {
        return getMinNumFactors(num, num, 2, Double.POSITIVE_INFINITY, new ArrayList<Integer>());
    }

    public static double getMinNumFactors(int original, int num, int index, double smallest, ArrayList<Integer> currentCombo) {
        if (num == 1) {
            if (isFactorsWithoutPerfectSquares(currentCombo)) {
                if (currentCombo.size() < smallest) {
                    smallest = currentCombo.size();
                }
            }
            return smallest;
        }

        for (int i = index; i <= num; i++) {
            if (num % i == 0 && i != original) {
                currentCombo.add(i);
                smallest = getMinNumFactors(original, num / i, i, smallest,  currentCombo);
                currentCombo.remove(currentCombo.size() - 1);
            }
        }

        return smallest;
    }

    public static boolean isFactorsWithoutPerfectSquares(ArrayList<Integer> factors) {
        for (int factor : factors) {
            if (Math.sqrt(factor) - Math.floor(Math.sqrt(factor)) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        double test = getMinNumFactors(12);
        System.out.println(test);
    }


}
