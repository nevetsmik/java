import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 7, 3, 4 };
        int[] answer = getProductsOfAllIntsExceptAtIndex(nums);
        System.out.println("The answer is: " + Arrays.toString(answer));
    }

    // Strategy: Iterate over the values in the input array and set the ith value in the resulting array equal to the
    // product of the previous ith - 1 entries in the input array. Iterate again starting from the end of the array using
    // the existing value in the ith index and the product of previous ith - 1 entries.
    static int[] getProductsOfAllIntsExceptAtIndex(int[] nums) {
        int[] result = new int[nums.length];

        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }
}
