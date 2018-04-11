import java.util.Arrays;

/*
Given an array containing zero and non zero digits you need to shift all the zeroes to the right of the array. Output
should be number of non zero elements present in array and minimum number of swaps needed to do so.

zerosToTheRight([1, 0, -6, 5, 0, 0, 2, 0]) === [4, 1]

4 (number of non zero elements)
1 (swap 2 with 0 present at index 1)
 */

public class Main {

    public static int[] zerosToTheRight(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int numSwaps = 0;
        int nonZeros = 0;

        while (left < right) {
            if (nums[left] == 0) {
                if (nums[left] == 0 && nums[right] != 0) {
                    numSwaps++;
                }
                while (nums[right] != 0) {
                    right--;
                    nonZeros++;
                }
                swap(nums, left, right);
                right--;
                left++;
            } else {
                left++;
                nonZeros++;
            }
        }
        return new int[] {numSwaps, nonZeros};
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] answer = zerosToTheRight(new int[] {1, 0, -6, 5, 0, 0, 2, 0});
        System.out.println(Arrays.toString(answer));
    }
}
