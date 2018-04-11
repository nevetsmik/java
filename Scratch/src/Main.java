import java.util.*;
import java.util.stream.*;

public class Main {

    public static String testStringBuffer() {
        StringBuffer test = new StringBuffer("Steve");
        return test.toString();
    }

    public static List<String> permutations(String str, int index) {
        if (index == str.length()) {
            ArrayList<String> baseCase = new ArrayList<String>();
            baseCase.add(str.substring(index));
            return baseCase;
        }

        String first = str.substring(index, index + 1);
        List<String> perms = permutations(str, index + 1);

        ArrayList<String> totalPermutations = new ArrayList<String>();

        for (String perm : perms) {
            for (int i = 0; i <= perm.length(); i++) {
                String newPerm = perm.substring(0, i).concat(first).concat(perm.substring(i));
                totalPermutations.add(newPerm);
            }
        }

        return totalPermutations;
    }

    public static List<String> subsets(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseCase = new ArrayList<String>(Arrays.asList(""));
            return baseCase;
        }

        String first = str.substring(0, 1);
        List<String> withoutFirst = subsets(str.substring(1));

        List<String> withFirst = withoutFirst.stream().map(sub -> {
            String newString = sub + first;
            return newString;
        }).collect(Collectors.toList());

        withoutFirst.addAll(withFirst);
        return withoutFirst;
    }

    static String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        }

        return str.substring(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        List<String> str = new ArrayList<>(Arrays.asList("S", "T", "E", "V", "E", "N" ));
        HashMap<String, Integer> freq = new HashMap<>();

        for (String s : str) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        freq.forEach((k,v) -> System.out.println("key: " + k + "; value: " + v));
        for(Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }

        System.out.println(reverse("Steve"));
    }
}
