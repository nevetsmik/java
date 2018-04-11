public class Main {

    public static <T extends Comparable<T>> int findRotationPoint(T[] words) {
        if (words[0].compareTo(words[words.length - 1]) < 0) {
            return 0;
        }

        if (words[words.length - 1].compareTo(words[words.length - 2]) < 0) {
            return words.length - 1;
        }

        return findRotationPoint(words, 0, words.length - 1);
    }

    public static <T extends Comparable<T>> int findRotationPoint(T[] words, int start, int end) {
        int midpoint = ((end - start + 1) / 2) + start;

        if (words[midpoint].compareTo(words[midpoint - 1]) < 0) {
            return midpoint;
        }

        if (start == end) {
            return -1;
        }

        if (words[midpoint].compareTo(words[start]) > 0) {
            return findRotationPoint(words, midpoint + 1, end);
        } else {
            return findRotationPoint(words, start, midpoint - 1);
        }

    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "karpatka",
                "othellolagkage",
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote", // <-- rotates here!
                "babka",
                "banoffee",
                "engender"
        };

        System.out.println(findRotationPoint(words));
    }
}
