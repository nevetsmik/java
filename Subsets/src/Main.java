import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Subsets for integers
    public static List<ArrayList<Integer>> subsets(ArrayList<Integer> nums, int index) {
        if (nums.size() == index) {
            List<ArrayList<Integer>> baseCase = new ArrayList<ArrayList<Integer>>();
            baseCase.add(new ArrayList<Integer>());
            return baseCase;
        }

        Integer first = nums.get(index);
        List<ArrayList<Integer>> withoutFirst = subsets(nums, index + 1);

        List<ArrayList<Integer>> withFirst = withoutFirst.stream()
                .map(sub -> {
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.addAll(sub);
                    newList.add(first);
                    return newList;
                })
                .collect(Collectors.toList());

        withoutFirst.addAll(withFirst);
        return withoutFirst;
    }

    // Subsets for a string
//    public static List<String> subsets(String str) {
//        if (str.length() == 0) {
//            ArrayList<String> baseCase = new ArrayList<String>(Arrays.asList(""));
//            return baseCase;
//        }
//
//        String first = str.substring(0, 1);
//        List<String> withoutFirst = subsets(str.substring(1));
//
//        List<String> withFirst = withoutFirst.stream()
//            .map(sub -> first + sub)
//            .collect(Collectors.toList());
//
//        withoutFirst.addAll(withFirst);
//        return withoutFirst;
//    }

    public static List<String> subsets (String str, int index) {
        if (index == str.length()) {
            List<String> baseCase = new ArrayList<String>();
            baseCase.add("");
            return baseCase;
        }

        String first = str.substring(index, index + 1);
        List<String> withoutFirst = subsets(str, index + 1);

        List<String> withFirst = withoutFirst.stream()
                .map(sub -> first + sub)
                .collect(Collectors.toList());

        withoutFirst.addAll(withFirst);
        return withoutFirst;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<ArrayList<Integer>> results = subsets(nums, 0);

        for (ArrayList<Integer> sub : results) {
            System.out.println(Arrays.toString(sub.toArray()));
        }

        List<String> result = subsets("abc", 0);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
