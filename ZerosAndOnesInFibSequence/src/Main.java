import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList<Integer> fibs(int n) {
        ArrayList<Integer> fibs = new ArrayList<>(Arrays.asList(0, 1));

        while (fibs.get(fibs.size() - 1) <= n) {
            fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
        }
        return fibs;
    }

    public static String getFibsSequenceOfZerosAndOnes(String str) {
        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < str.length(); i++) {
            char ltr = str.charAt(i);
            if (ltr == '1') {
                ones++;
            } else {
                zeros++;
            }
        }

        String result = "0";
        ArrayList<Integer> fibSequence = fibs(zeros + ones);
        System.out.println(Arrays.toString(fibSequence.toArray()));
        for (int i = 0; i < fibSequence.size(); i++) {
            if (zeros == 0 && ones == 0) {
                break;
            }
            if (i % 2 == 0) {
                if (fibSequence.get(i) > zeros) {
                    result += printOnesAndZeros(zeros, '0');
                } else {
                    result += printOnesAndZeros(fibSequence.get(i), '0');
                }
                zeros -= fibSequence.get(i);
            } else {
                if (fibSequence.get(i) > ones) {
                    result += printOnesAndZeros(ones, '1');
                } else {
                    result += printOnesAndZeros(fibSequence.get(i), '1');
                }
                ones -= fibSequence.get(i);
            }
        }

        return result;
    }

    public static String printOnesAndZeros(int numTimes, char chr) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < numTimes; i++) {
            result.append(chr);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(0 % 2 == 0);
        System.out.println(getFibsSequenceOfZerosAndOnes("00101111011101011000"));

        // Output should be "01001110000011111110"
    }
}
