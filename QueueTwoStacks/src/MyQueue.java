import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> in = new Stack<>();
    private Stack<T> out = new Stack<>();

    public void enqueue(T ob) {
        in.push(ob);
    }

    public T dequeue() {
        // if out is empty
        if (out.empty()) {
            // move all the elements from the in stack to the out stack
            moveInToOut();
        }

        // pop from dequeue stack
        return out.pop();
    }

    private void moveInToOut() {
        while(!in.empty()) {
            out.push(in.pop());
        }
    }
}
