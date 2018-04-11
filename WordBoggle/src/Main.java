import java.util.*;

public class Main {

    public static List<String> wordBoggle(char[][] board, List<String> words) {
        boolean[][] visited = makeVisited(board.length, board[0].length);
        HashMap<String, Boolean> result = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                visited[row][col] = true;
                exploreForWords(board, words, row, col, "" + board[row][col], visited, result);
                visited[row][col] = false;
            }
        }

        return new ArrayList<String>(result.keySet());
    }

    public static void exploreForWords(char[][] board, List<String> words, int row, int col, String currentWord,
                                       boolean[][] visited, HashMap<String, Boolean> result) {
        if (words.contains(currentWord)) {
            result.put(currentWord, true);
            return;
        }


        if (isPotentialWord(currentWord, words)) {
            int [] dx = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
            int [] dy = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};

            for (int i = 0; i < dx.length; i++) {
                if (isValid(board, row + dx[i], col + dy[i]) && !visited[row + dx[i]][col + dy[i]]) {
                    visited[row + dx[i]][col + dy[i]] = true;
                    exploreForWords(board, words, row + dx[i], col + dy[i], currentWord + board[row + dx[i]][col + dy[i]], visited, result);
                    visited[row + dx[i]][col + dy[i]] = false;
                }
            }
        }
    }

    public static boolean isValid(char[][]board, int x, int y) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
            return true;
        }
        return false;
    }

    public static boolean isPotentialWord(String possibleWord, List<String> words) {
        for (String word : words) {

            if (word.startsWith(possibleWord)) {
                return true;
            }
        }
        return false;
    }

    public static boolean[][] makeVisited(int numRows, int numCols) {
        boolean[][] visited = new boolean[numRows][numCols];
        return visited;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { {'R', 'L', 'D'},
                                        {'U', 'O', 'E'},
                                        {'C', 'S', 'O'}};
        List<String> words = new ArrayList<String>(Arrays.asList("CODE", "SOLO", "RULES", "COOL"));

        List<String> result = wordBoggle(board, words);
        System.out.println("Result: " + result);
    }
}
