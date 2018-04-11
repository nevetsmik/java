import java.util.ArrayList;
import java.util.Arrays;

public class PathWithTurns {
    private ArrayList<BinaryTree<Integer>> path;
    private int leftCount;
    private int rightCount;

    public PathWithTurns() {
        path = new ArrayList<BinaryTree<Integer>>();
        leftCount = 0;
        rightCount = 0;
    }

    public int getLeftCount() {
        return this.leftCount;
    }

    public int getRightCount() {
        return this.rightCount;
    }

    public void addNode(BinaryTree<Integer> node) {
        this.path.add(node);
    }

    public void popNode() {
        this.path.remove(path.size() - 1);
    }

    public void incrementLeft() {
        this.leftCount++;
    }

    public void decrementLeft() {
        this.leftCount--;
    }

    public void incrementRight() {
        this.rightCount++;
    }

    public void decrementRight() {
        this.rightCount--;
    }

    public String printNodes() {
        return Arrays.toString(this.path.toArray());
    }

    public String printTurns() {
        return "Left Count: " + this.getLeftCount() + "; Right Count: " + this.getRightCount();
    }
}
