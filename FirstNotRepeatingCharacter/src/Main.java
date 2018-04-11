import java.util.Arrays;

public class Main {

    static char firstNotRepeatingCharacter(String str) {
        int[] lettersCount = new int[26];
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            int aAsciiCode = (int) 'a';
            int asciiCode = (int) strArray[i];
            lettersCount[asciiCode - aAsciiCode] += 1;
        }

        System.out.println(Arrays.toString(lettersCount));

        for (int i = 0; i < strArray.length; i++) {
            int aAsciiCode = (int) 'a';
            int asciiCode = (int) strArray[i];
            if (lettersCount[asciiCode - aAsciiCode] == 1) {
                return (char)(strArray[i]);
            }
        }

        return '_';
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
    }
}
