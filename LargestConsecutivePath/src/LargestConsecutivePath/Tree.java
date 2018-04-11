package LargestConsecutivePath;

import java.util.ArrayList;

public class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public int getValue() {
        return value;
    }

    public Tree(int value) {
        this.value = value;

        this.left = null;
        this.right = null;
    }

    public Tree insertLeft(int value) {
       this.left = new Tree(value);
       return this.left;
    }

    public Tree insertRight(int value) {
        this.right = new Tree(value);
        return this.right;
    }

    public ArrayList<Tree> traverseDFInOrder(Tree node) {
        ArrayList<Tree> result = new ArrayList<Tree>();

        if (node == null) {
            return result;
        }

        result.addAll(traverseDFInOrder(node.left));

        result.add(node);

        result.addAll(traverseDFInOrder(node.right));

        return result;
    }

    public int largestConsecutivePath(Tree node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + largestConsecutivePath(node, node.value);
        }
    }

    private int largestConsecutivePath(Tree node, int prevValue) {
        int leftSide;
        int rightSide;
        int currentCount = 0;

        if (node == null) {
            return 0;
        }

        if (node.value == prevValue + 1) {
            currentCount += 1;
        } else {
            currentCount = 0;
        }

        leftSide = currentCount + node.largestConsecutivePath(node.left, node.value);

        rightSide = currentCount + node.largestConsecutivePath(node.right, node.value);

        return Math.max(leftSide, rightSide);
    }
}
