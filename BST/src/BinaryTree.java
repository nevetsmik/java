import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    public T value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinaryTree insertLeft(T value) {
        this.left = new BinaryTree<T>(value);
        return this.left;
    }

    public BinaryTree insertRight(T value) {
        this.right = new BinaryTree<T>(value);
        return this.right;
    }

    public String toString() {
        if (this == null) {
            return "null";
        }
        return "" + this.value;
    }
}
