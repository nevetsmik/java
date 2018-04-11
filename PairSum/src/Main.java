

import java.util.*;

public class Main {

    /*
    Given an array of numbers and a target number, find a pair of numbers that sum to the target number.
    */
    public static List<Integer> pairSum(List<Integer> numbers, Integer targetSum) {
        HashMap<Integer, Integer> complements = new HashMap<>();

        for (Integer num : numbers) {
            Integer complement = targetSum - num;
            if (complements.containsKey(complement)) {
                return new ArrayList<Integer>(Arrays.asList(complement, num));
            } else {
                complements.put(num, num);
            }
        }

        return null;
    }

    /*
    Given an array of numbers and a target number, find ALL pairs of numbers that sum to the target number. Deal with
    duplicates such that duplicate pairs are accounted for.

    Example:

    Integer[] numbers = {4, 6, 4, 6};
    List<Integer> nums = new ArrayList<Integer>(Arrays.asList(numbers));

    findAllPairSums(nums, 10) == { {4, 6}, {4, 6} }

    */
    public static List<ArrayList<Integer>> findAllPairSums(List<Integer> nums, int targetSum) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (Integer num : nums) {
            int complement = targetSum - num;
            if (complements.getOrDefault(complement, 0) > 0) {
                result.add(new ArrayList<Integer>(Arrays.asList(num, complement)));
                complements.put(complement, complements.getOrDefault(complement, 0) - 1);
            } else {
                complements.put(complement, complements.getOrDefault(complement, 0) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 5));
        List<Integer> result = pairSum(list, 11);
        System.out.println("Result: " + result);

        Integer[] numbers = {4, 6, 4, 6};
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(numbers));
        System.out.println("Result: " + findAllPairSums(nums, 10));
    }
}
