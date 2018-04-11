import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int nthFibonacci(int n) {
        // 0, 1, 1, 2, 3
        return nthFibonacciRec(n, new int[n + 1]);
    }

    public static int nthFibonacciRec(int n, int[] result) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (result[n] == 0) {
            result[n] = nthFibonacciRec(n - 1, result) + nthFibonacciRec(n - 2, result);
        }
        return result[n];
    }

    public static int nthFibonacciDP(int n) {
        List<Integer> fibs = new ArrayList<Integer>(Arrays.asList(0, 1));
        if (n == 0 || n == 1) {
            return fibs.get(n);
        }

        for (int i = 2; i <= n; i++) {
            fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
        }

        return fibs.get(n);
    }

    public static void main(String[] args) {
        int n = 8;
        int fibsRec = nthFibonacciDP(n);
        System.out.println("nthFibonacci where n is " + n + ": " + fibsRec);
    }
}
