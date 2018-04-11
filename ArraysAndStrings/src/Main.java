import java.util.Arrays;

public class Main {

    static boolean hasUniqueCharacters(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedString = new String(chars);
        for (int i = 0; i < sortedString.length() - 1; i++) {
            if (sortedString.charAt(i) == sortedString.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {
	// write your code here
    }
}
