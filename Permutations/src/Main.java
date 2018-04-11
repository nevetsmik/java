import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Arrays;

public class Main {

    public static ArrayList<String> permutations(String str, int index) {
        if (index == str.length() - 1) {
            ArrayList<String> baseCase = new ArrayList<>();
            baseCase.add(Character.toString(str.charAt(index)));
            return baseCase;
        }

        String first = Character.toString(str.charAt(index));
        ArrayList<String> perms = permutations(str, index + 1);

        ArrayList<String> totalPerms = new ArrayList<>();

        for (String perm : perms) {
            for (int i = 0; i <= perm.length(); i++) {
                String newPerm = perm.substring(0, i).concat(first).concat(perm.substring(i));
                totalPerms.add(newPerm);
            }
        }

        return totalPerms;
    }

    public static void main(String[] args) {
        ArrayList<String> result = permutations("abc", 0);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
