import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int[] findFirstTwoMinimumValuesInArray(int[] array) {
        if (array.length <= 2) {
            return array;
        }

        int min1 = Math.min(array[0], array[1]);
        int min2 = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            if (array[i] < min1) {
                min2 = min1;
                min1 = array[i];
            } else if (array[i] < min2) {
                min2 = array[i];
            }
        }

        return new int[] {min1, min2};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {87, 24, 55, 18, 29, 11, 56, 34, 8};
        int[] answer = findFirstTwoMinimumValuesInArray(nums);
        System.out.println(Arrays.toString(answer));
    }
}
