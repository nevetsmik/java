import java.util.Stack;
import java.lang.Comparable;

public class Main {

    public class MaxStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> maxStack = new Stack<>();

        public void push(int value) {
            stack.add(value);
            if (maxStack.empty() || maxStack.peek() < value) {
                maxStack.add(value);
            }
        }

        public int pop() {
            int removed = stack.pop();
            if (removed == maxStack.peek()) {
                maxStack.pop();
            }
            return removed;
        }

        public int getMax() {
            return maxStack.peek();
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
