import java.util.*;

public class Main {

    static List<ArrayList<Integer>> getFactors(int n) {
        return getFactors(n, n, 2, new ArrayList<Integer>());
    }

    static List<ArrayList<Integer>> getFactors(int original, int n, int start, ArrayList<Integer> current) {
        List<ArrayList<Integer>>  allFactors = new ArrayList<ArrayList<Integer>>();

        if (n == 1) {
            if (current.get(0) != original) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(current);
                System.out.println("current: " + current);
                allFactors.add(temp);
            }
            return allFactors;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                current.add(i);
                allFactors.addAll(getFactors(original, n / i, i, current));
                current.remove(current.size() - 1);
            }
        }

        return allFactors;
    }

    public static void main(String[] args) {
	    List<ArrayList<Integer>> result = getFactors(8);
	    for (ArrayList<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }
}
