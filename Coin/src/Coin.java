import java.util.*;


public class Coin {

//    static int coinSums(int amount, int[] coins) {
//        return coinSums(amount, coins, 0, new HashMap<String, Integer>());
//    }
//
//    static int coinSums(int amount, int[] coins, int index, HashMap<String, Integer> memo) {
//        String key = amount + "-" + index;
//        if (memo.containsKey(key)) {
//            return memo.get(key);
//        }
//
//        if (amount == 0) {
//            return 1;
//        }
//
//        if (amount < 0) {
//            return 0;
//        }
//
//        if (index > coins.length - 1) {
//            return 0;
//        }
//
//        int numPossibilities = 0;
//
//        for (int i = index; i < coins.length; i++) {
//            if (amount - coins[i] < 0) {
//                continue;
//            }
//            numPossibilities += coinSums(amount - coins[i], coins, i, memo);
//        }
//
//        memo.put(key, numPossibilities);
//
//        return numPossibilities;
//    }

    public static ArrayList<ArrayList> coins(int amount, int[] coins) {
        return coins(amount, coins, 0, new ArrayList<Integer>(), new ArrayList<ArrayList>());
    }

    public static ArrayList<ArrayList> coins(int amount, int[] coins, int index, ArrayList<Integer> currentCombo, ArrayList<ArrayList> result) {
        if (amount == 0) {
            ArrayList<Integer> clone = (ArrayList<Integer>) currentCombo.clone();
            result.add(clone);
            return result;
        }

        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] < 0) {
                continue;
            }
            currentCombo.add(coins[i]);
            coins(amount - coins[i], coins, i, currentCombo, result);
            currentCombo.remove(currentCombo.size() - 1);
        }
        return result;
    };


    public static void main(String[] args) {
        int amount = 12;
        int[] coins = {9, 4, 1};

//        int coinSums = coinSums(amount, coins);
//        System.out.println("Number of possible ways to make " + 4 + " cents out of " + Arrays.toString(coins) + ":");
//        System.out.println(coinSums);

        ArrayList<ArrayList> result = coins(amount, coins);
        int min = Integer.MAX_VALUE;
        ArrayList<ArrayList> minList = result.get(0);
        for (ArrayList itr : result) {
            if (itr.size() < min) {
                min = itr.size();
                minList = itr;
            }
        }
        System.out.println(minList.toString());


    }
}
