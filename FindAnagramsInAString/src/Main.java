import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given a String and a pattern find all anagrams of the pattern in the original string. You need to print all the index of
the location where the match was found

Example:

findAnagramPositions("ABDACDBACA", "ABCD") === [1, 3, 4, 5]

Index 1 BDAC , at index 3 ACDB and so on )
*/

public class Main {

    public static ArrayList<Integer> findAnagramPositions(String original, String anagram) {
        String sortedAnagram = sortAnagram(anagram);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < original.length(); i++) {
            String current;
            if (i + sortedAnagram.length() >= original.length()) {
                current = original.substring(i);
            } else {
                current = original.substring(i, i + sortedAnagram.length());
            }
            if (sortAnagram(current).equals(sortedAnagram)) {
                result.add(i);
            }
        }
        return result;
    }

    public static String sortAnagram(String anagram) {
        char[] chars = anagram.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        ArrayList<Integer> answer = findAnagramPositions("ABDACDBACA", "ABCD");
        System.out.println(Arrays.toString(answer.toArray()));
    }
}
