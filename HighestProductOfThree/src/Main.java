public class Main {

    public static void main(String[] args) {
        int[] numbers = { -10, -10, 1, 3, 2 };
        int answer = highestProductOfThree(numbers);
        System.out.println("The answer is: " + answer);
    }

    static int highestProductOfThree(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("Less than 3 arguments!");
        }
        /* Method 1: O(n log n)
        - Sort the array
        - Multiply the last value by the max of the product of the first 2 or the second to last 2

        Arrays.sort(nums);
        int highestProductOfTwo = Math.max(nums[0] * nums[1], nums[nums.length - 2] * nums[nums.length - 3]);
        return highestProductOfTwo * nums[nums.length - 1];
         */

        /* Method 2: O(n)
        - Use a greedy approach to keep track of the information needed to determine highest product of 3 at
         each iteration
        - At each iteration:
            - Keep track of highest product of 2 * current value
            - Keep track of highest product of 2
                - Highest product of 2 is lowest * current or highest * current
            - Keep track of highest and lowest values
         */

        int highestProductOfThree = nums[0] * nums[1] * nums[2];
        int highestProductOfTwo = nums[0] * nums[1];
        int lowest = Math.min(nums[0], nums[1]);
        int highest = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (highestProductOfThree < highestProductOfTwo * nums[i]) {
                highestProductOfThree = highestProductOfTwo * nums[i];
            }

            if (highestProductOfTwo < Math.max(lowest * nums[i], highest * nums[i])) {
                highestProductOfTwo = Math.max(lowest * nums[i], highest * nums[i]);
            }

            if (highest < Math.max(highest, nums[i])) {
                highest = Math.max(highest, nums[i]);
            }

            if (lowest < Math.min(lowest, nums[i])) {
                lowest = Math.min(lowest, nums[i]);
            }
        }

        return highestProductOfThree;
    }
}
