import javafx.geometry.Side;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void mergeSort(ArrayList<Integer> array) {
        mergeSort(array, 0, array.size() - 1);
    }

    public static void mergeSort(ArrayList<Integer> array, int left, int right) {
        if (left < right) {
            int middle = (right + left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, right);
        }
    }

    public static void merge(ArrayList<Integer> array, int left, int right) {
        int middle = (right + left) / 2;
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        ArrayList<Integer> leftSide = new ArrayList<>(leftSize);
        ArrayList<Integer> rightSide = new ArrayList<>(rightSize);

        for (int i = left; i <= middle; i++) {
            leftSide.add(array.get(i));
        }
        for (int i = middle + 1; i <= right; i++) {
            rightSide.add(array.get(i));
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSide.size() && j < rightSide.size()) {
            if (leftSide.get(i) < rightSide.get(j)) {
                array.set(k, leftSide.get(i));
                i++;
            } else if (rightSide.get(j) <= leftSide.get(i)) {
                array.set(k, rightSide.get(j));
                j++;
            }
            k++;
        }

        while (i < leftSide.size()) {
            array.set(k, leftSide.get(i));
            i++;
            k++;
        }

        while (j < rightSide.size()) {
            array.set(k, rightSide.get(j));
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{12, 388, 40, 32, 100, 99};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println("Before mergeSort: " + Arrays.toString(list.toArray()));
        mergeSort(list);
        System.out.println(" After mergeSort: " + Arrays.toString(list.toArray()));
    }
}
