import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static List<ArrayList<Integer>> houseRobber(int[] houses) {

        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] dp = new int[houses.length + 2];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i - 2]);
        }

        ArrayList<Integer> value = new ArrayList<Integer>(Arrays.asList(dp[dp.length - 1]));
        result.add(value);

        ArrayList<Integer> robbedHouses = new ArrayList<>();

        for (int i = dp.length - 1; i >= 2; ) {
            if (dp[i] == houses[i - 2] + dp[i - 2]) {
                robbedHouses.add(i - 2);
                i -= 2;
            } else {
                i--;
            }
        }
        result.add(robbedHouses);

        return result;
    }

    public static void main(String[] args) {
//        int[] houses = new int[] { 25, 20, 10, 35, 60 ,15 }; // [ [95], [4, 2, 0] ]
        int[] houses = new int[] { 30, 0, 0, 25, 0, 15 }; // [ [70], [5, 3, 0]]

        System.out.println(houseRobber(houses));
    }
}
