import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList<Integer> quickSort(ArrayList<Integer> array) {
        return quickSort(array, 0, array.size() - 1);
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }

        return array;
    }

//    public static int partition(ArrayList<Integer> array, int left, int right) {
//        int random = (int) (Math.random() * (right - left + 1)) + left;
//        swap(array, left, random);
//
//        int pivot = left;
//        int partition = left;
//
//        for (int i = left; i <= right; i++) {
//            if (array.get(i) < array.get(pivot)) {
//                partition++;
//                swap(array, i, partition);
//            }
//        }
//        swap(array, pivot, partition);
//        return partition;
//    }

    public static int partition(ArrayList<Integer> array, int left, int right) {
        int random = (int) (Math.random() * (right - left + 1)) + left;
        int pivot = array.get(random);
        while (left <= right) {
            if (array.get(left) > pivot) {
                swap(array, left, right);
                right--;
            } else if (array.get(right) <= pivot) {
                swap(array, left, right);
                left++;
            } else {
                left++;
                right--;
            }
        }
        return left - 1;
    }

    public static Integer quickSelect(ArrayList<Integer> array, int k) {
        if (k < 1 || k > array.size()) {
            return -1;
        }
        return quickSelect(array, k, 0, array.size() - 1);
    }

    public static Integer quickSelect(ArrayList<Integer> array, int k, int left, int right) {
        if (left == right) {
            return array.get(left);
        }

        int pivot = partition(array, left, right);

        if (pivot + 1 == k) {
            return array.get(pivot);
        }

        if (k < pivot + 1) {
            return quickSelect(array, k, left, pivot - 1);
        }

        return quickSelect(array, k, pivot + 1, right);
    }

    public static void swap(ArrayList<Integer> array, int x, int y) {
        Integer temp = array.get(x);
        array.set(x, array.get(y));
        array.set(y, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(100, 32, 94, 73, 22, 11, 73, 3, 4));
        // 3, 4, 11, 22, 32, 73, 73, 94, 100
        int pivot = partition(array, 0, array.size() - 1);
        System.out.println("pivot: " + pivot);
        System.out.println(Arrays.toString(array.toArray()));
//        quickSort(array);
//        System.out.println(Arrays.toString(array.toArray()));
//        System.out.println(quickSelect(array, 10));
    }
}
