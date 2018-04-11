import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static int[] mergeTwoSortedArrays(int[] left, int[] right) {
        int i  = 0;
        int j = 0;
        int k = 0;

        int[] result = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            switch(((Integer) left[i]).compareTo((Integer) right[j])) {
                case -1:
                    result[k] = left[i];
                    i++;
                    break;
                case 0:
                    result[k] = right[j];
                    j++;
                    break;
                case 1:
                    result[k] = right[j];
                    j++;
                    break;
            }
            k++;
        }

        for ( ; i < left.length; i++) {
            result[k] = left[i];
            k++;
        }

        for ( ; j < right.length; j++) {
            result[k] = right[j];
        }

        return result;
    }

    public static List<Integer> mergeTwoSortedLists(LinkedList<Integer> left, LinkedList<Integer> right) {

        List<Integer> result = new LinkedList<Integer>();

        while (left.size() > 0 && right.size() > 0) {
            switch(left.peek().compareTo(right.peek())) {
                case -1:
                    result.add(left.poll());
                    break;
                case 0:
                    result.add(right.poll());
                    break;
                case 1:
                    result.add(right.poll());
                    break;
            }
        }
        result.addAll(left);
        result.addAll(right);
        return result;
    }


    public static void main(String[] args) {
        int[] left = {1, 4, 6, 10, 12};
        int[] right = {3, 8, 11, 21};

        int[] result = mergeTwoSortedArrays(left, right);
        System.out.println(Arrays.toString(result));

        Integer[] leftInteger = {1, 4, 6, 10, 12};
        Integer[] rightInteger = {3, 8, 11, 21};

        LinkedList<Integer> first = new LinkedList(Arrays.asList(leftInteger));
        LinkedList<Integer> second = new LinkedList(Arrays.asList(rightInteger));

        List<Integer> firstAndSecond = mergeTwoSortedLists(first, second);
        System.out.println(Arrays.toString(firstAndSecond.toArray()));
    }
}
