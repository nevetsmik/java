public class Main {

    public static String stringCompressor(String str) {
        char[] chars = str.toCharArray();
        String result = "";
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                result += "" + chars[i] + count;
                count = 1;
            }
        }
        result += "" + chars[chars.length - 1] + count;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(stringCompressor("a"));
    }
}
