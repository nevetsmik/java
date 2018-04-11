public class Main {

    static String longestPalindromicSubstring(String str) {
        String palindrome = "";
        int left;
        int right;
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {

            // Evens
            left = i;
            right = i + 1;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    palindrome = str.substring(left, right + 1);
                }
                left--;
                right++;
            }

            // Odds
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    palindrome = str.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return palindrome;
    }

    static String longestPalindromicSubstring2(String str) {
        String palindrome = "";
        char[] letters = str.toCharArray();

        int left;
        int right;
        int maxLength = 0;

        for (int i = 0; i < letters.length; i++) {

            // Evens
            left = i;
            right = i + 1;
            while (left >= 0 && right < letters.length && letters[left] == letters[right]) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    palindrome = new String(letters, left, right - left + 1);
                }
                left--;
                right++;
            }

            // Odds
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < letters.length && letters[left] == letters[right]) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    palindrome = new String(letters, left, right - left + 1);
                }
                left--;
                right++;
            }
        }
        return palindrome;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring2("forgeeksskeegfor"));
        String test = "steve";
        System.out.println(test.substring(0, test.length()));
    }
}
