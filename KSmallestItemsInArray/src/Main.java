import java.util.*;

public class Main {

    static List<Integer> kSmallestIntegersInArray(List<Integer> nums, int k) {
        int threshold = kSmallestIntegersInArrayHelper(nums, k - 1, 0, nums.size() - 1);
        System.out.println(threshold);
        List<Integer> result = new ArrayList<>();
        for (Integer num : nums) {
            if (num < threshold) {
                result.add(num);
            }
        }
        return result;
    }

    static int kSmallestIntegersInArrayHelper(List<Integer> nums, int k, int start, int end) {
        if (start == end) {
            return nums.get(start);
        }

        int pivot = partition(nums, start, end);

        if (k == pivot) {
            return nums.get(pivot);
        }

        if (k < pivot) {
            return kSmallestIntegersInArrayHelper(nums, k, start, pivot);
        } else {
            return kSmallestIntegersInArrayHelper(nums, k, pivot, end);
        }
    }

    static int partition(List<Integer> nums, int start, int end) {
        int randomPivot = (int) (Math.random() * (end - start + 1)) + start;
        int pivot = nums.get(randomPivot);

        while (start < end) {
            while (nums.get(start) > pivot) {
                start++;
            }

            while (nums.get(end) < pivot) {
                end--;
            }

            if (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    static void swap(List<Integer> nums, int left, int right) {
        int temp = nums.get(left);
        nums.set(left, nums.get(right));
        nums.set(right, temp);
    }

    public static void main(String[] args) {
        List<Integer> unsortedNums = new ArrayList<>(Arrays.asList(30, 25, 27, 52, 10, 16, 8));
        List<Integer> kSmallestIntegers = kSmallestIntegersInArray(unsortedNums, 0);
        System.out.println(kSmallestIntegers);
    }
}
