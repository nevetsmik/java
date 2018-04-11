import java.util.Arrays;

public class Main {
    public static int[] shuffle(int[] deck) {
        int i = deck.length;
        while (i > 0) {
            int randomSlot = (int) (Math.random() * i);
            System.out.println(randomSlot);
            swap(deck, randomSlot, i - 1);
            i--;
        }
        return deck;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] deck = new int[52];
        for (int i = 1; i <= deck.length; i++) {
            deck[i - 1] = i;
        }

        System.out.println(Arrays.toString(shuffle(deck)));
    }
}
