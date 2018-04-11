import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static <T extends Comparable<T>> int binarySearch(List<T> list, T target) {
        //return binarySearchIter(list, target, 0, list.size() - 1);
        return binarySearchRec(list, target, 0, list.size());
    }

    public static <T extends Comparable<T>> int binarySearchIter(List<T> list, T target, int start, int end) {
        while (start <= end) {
            int midpoint = ((end - start + 1) / 2) + start;
            System.out.println("list[midpoint]: " + list.get(midpoint));

            if (list.get(midpoint).equals(target)) {
                return midpoint;
            }

            int comp = list.get(midpoint).compareTo(target);
            if (comp < 0) {
                start = midpoint + 1;
            }
            if (comp > 0) {
                end = midpoint - 1;
            }
        }

        return -1;
    }

    public static <T extends Comparable<T>> int binarySearchRec(List<T> list, T target, int start, int end) {
        int midpoint = ((end - start + 1) / 2) + start;

        if (list.get(midpoint) == target) {
            return midpoint;
        }

        if (start == end) {
            return -1;
        }

        if (list.get(midpoint).compareTo(target) < 0) {
            return binarySearchRec(list, target,midpoint + 1, end);
        } else {
            return binarySearchRec(list, target, start, midpoint - 1);
        }
    }

    public static void main(String[] args) {

        Integer[] array = { 3, 5, 7, 10, 12, 13, 15, 17, 20, 25, 27, 30, 32, 35, 36 };
        System.out.println(binarySearch(Arrays.asList(array), 27));

    }
}
