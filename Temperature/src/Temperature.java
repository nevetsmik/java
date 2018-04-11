import java.util.HashMap;

public class Temperature {

    private HashMap<Integer, Integer> frequency = new HashMap<>();
    private int maxOccurences;
    private int sum = 0;
    private int size = 0;
    private int mean;
    private int min = Integer.MIN_VALUE;
    private int max = Integer.MAX_VALUE;
    private int mode;

    public void insert(int value) {

        // for mode
        if (this.frequency.containsKey(value)) {
            this.frequency.put(value, this.frequency.get(value) + 1);
        } else {
            this.frequency.put(value, 1);
        }

        if (this.frequency.get(value) > this.maxOccurences) {
            this.maxOccurences = this.frequency.get(value);
            this.mode = value;
        }

        // for mean
        this.sum += value;
        this.size += 1;
        this.mean = sum / value;

        // for min
        this.min = Math.min(this.min, value);

        // for max
        this.max = Math.max(this.max, value);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getMean() {
        return sum / size;
    }

    public int getMode() {
        return mode;
    }
}
