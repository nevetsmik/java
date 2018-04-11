import java.util.HashMap;
import java.util.Set;

public class Main {

    public static Set<Integer> findUniqueDeliveryId(int[] deliveryIds) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (Integer id : deliveryIds) {
            if (freq.containsKey(id)) {
                freq.remove(id);
            } else {
                freq.put(id, 1);
            }
        }
        return freq.keySet();
    }

    public static void main(String[] args) {
        int[] ids = { 100, 100, 200, 200, 300, 300, 400 };
        System.out.println(findUniqueDeliveryId(ids).toArray()[0]);
    }
}
