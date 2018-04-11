import java.util.Arrays;

public class Main {

    static int[][] rotateArray(int[][] array) {
        int[][] rotatedArray = new int[array[0].length][array.length];

        int newCol = array.length - 1;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                rotatedArray[col][newCol] = array[row][col];
            }
            newCol--;
        }

        return rotatedArray;
    }

    static void print(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            System.out.println(Arrays.toString(array[row]));
        }
    }

    public static void main(String[] args) {
	    int[][] array = new int[][] { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} };
        print(array);
        System.out.println();
        print(rotateArray(array));
    }
}
