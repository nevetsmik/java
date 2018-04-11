import java.util.HashMap;

public class Main {

    public static boolean match(String pattern, String str) {
        return match(str, pattern, new HashMap<>());
    }

    public static boolean match(String pattern, String str, HashMap<Character, String> map) {
        if (pattern.length() == 1) {
            if (map.containsKey(pattern.charAt(0))) {
                String subPattern = map.get(pattern.charAt(0));
                if (subPattern.equals(str.substring(0, subPattern.length()))) {
                    return true;
                }
            } else {
                return false;
            }
        }

        if ((pattern.length() == 0 && str.length() != 0) || (pattern.length() != 0 && str.length() == 0)) {
            return false;
        }

        if (map.containsKey(pattern.charAt(0))) {
            String subPattern = map.get(pattern.charAt(0));
            if (subPattern.equals(str.substring(0, subPattern.length()))) {
                return match(pattern.substring(1), str.substring(subPattern.length()), map);
            } else {
                return false;
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                map.put(pattern.charAt(0), str.substring(i + 1));
                if (match(pattern.substring(1), str.substring(i + 1))) {
                    return true;
                } else {
                    map.remove(pattern.charAt(0));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "redbluered";
        String pattern = "abc";

        System.out.println("The string '" + str + "' matches the pattern '" + pattern + "': " + match(str, pattern));
    }
}
