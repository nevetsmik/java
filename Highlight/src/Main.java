import java.util.*;
import java.util.stream.Collectors;

/*
Input: a string and a list of words.
Output: a string
Problem: For any substring in the input string that matches a word in the list of words, enclose the substring
in <>. Minimize the number of brackets where possible and wrap overlapping substrings within a single <>. For example,
if the input string is "foobargooglebazbarpooold" and the list of words is ["foo", "bar", "baz", "zba", "poo"], then the
correct output string is "<foobar>google<bazbarpoo>old". An incorrect implementation is the following:
<foo><bar>google<ba<z><ba>r><poo>old
*/

public class Main {

    static String highlight(String[] words, String str) {
        List<Integer> openAngle = new ArrayList<>();
        List<Integer> closedAngle = new ArrayList();

        for (String word : words) {
            for (int j = 0; j < str.length() - word.length(); j++) {
                if (word.equals(str.substring(j, j + word.length()))) {
                    openAngle.add(j);
                    closedAngle.add(j + word.length());
                }
            }
        }

        Collections.sort(openAngle);
        Collections.sort(closedAngle);

        StringBuffer withUglyBrackets = new StringBuffer();
        int start = 0;

        while (!openAngle.isEmpty() && !closedAngle.isEmpty()) {
            if (openAngle.get(0) <= closedAngle.get(0)) {
                int position = openAngle.remove(0);
                withUglyBrackets.append(str.substring(start, position));
                withUglyBrackets.append("<");
                start = position;
            } else {
                int position = closedAngle.remove(0);
                withUglyBrackets.append(str.substring(start, position));
                withUglyBrackets.append(">");
                start = position;
            }
        }

        while (!closedAngle.isEmpty()) {
            int position = closedAngle.remove(0);
            withUglyBrackets.append(str.substring(start, position));
            withUglyBrackets.append(">");
            start = position;
        }

        if (start < str.length()) {
            withUglyBrackets.append(str.substring(start));
        }

        return prettify(withUglyBrackets.toString());
    }

    static String prettify(String str) {
        StringBuffer result = new StringBuffer();

        int openBracket = 0;
        int closeBracket = 0;

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            if (letter == '>') {
                closeBracket++;
            }

            if (openBracket == closeBracket || (letter != '<' && letter != '>')) {
                result.append(letter);
            }

            if (letter == '<') {
                openBracket++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] words = {"foo", "bar", "baz", "zba", "poo"};
        String str = "foobargooglebazbarpooold";

        String result = highlight(words, str);
        System.out.println(result);
    }
}
