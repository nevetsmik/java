import java.util.*;

public class Main {

    static int[][] makeBinomialCoefficients(int n) {
        int[][] bc = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            bc[i][0] = 1;
            bc[i][i] = 1;
        }

        for (int row = 2; row <= n; row++) {
            for (int col = 1; col < row; col++) {
                bc[row][col] = bc[row - 1][col - 1] + bc[row - 1][col];
            }
        }
        return bc;
    }

    static int nChooseM(int n, int m) {
        int[][] bc = makeBinomialCoefficients(n);
        return bc[n][m];
    }

    public static void main(String[] args) {
        System.out.println(nChooseM(5, 3));
    }
}
