import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> pathWithMostBends(BST root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> currentPath = new ArrayList<>(root.value);
        currentPath.add(root.value);

        PathCount leftPath = pathWithMostBends(root.left, "left", 0, currentPath, new PathCount());
        PathCount rightPath = pathWithMostBends(root.right, "right", 0, currentPath, new PathCount());

        if (leftPath.turnCount > rightPath.turnCount) {
            return leftPath.path;
        } else {
            return rightPath.path;
        }
    }

    public static PathCount pathWithMostBends(BST root, String previousDirection, int currentBends, List<Integer> currentPath, PathCount result) {
        if (root == null) {
            if (currentBends > result.turnCount) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(currentPath);
                result.path = temp;
                result.turnCount = currentBends;
            }
            return result;
        }

        currentPath.add(root.value);

        if (previousDirection == "left") {
            pathWithMostBends(root.left, "left", currentBends, currentPath, result);
            pathWithMostBends(root.right, "right", currentBends + 1, currentPath, result);
        }

        if (previousDirection == "right") {
            pathWithMostBends(root.left, "left", currentBends + 1, currentPath, result);
            pathWithMostBends(root.right, "right", currentBends, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);

        return result;
    }
    public static BST insert(BST root, int value) {
        if (root == null) {
            return new BST(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        }

        if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static List<Integer> inorder(BST root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.addAll(inorder(root.left));
        result.add(root.value);
        result.addAll(inorder(root.right));

        return result;
    }


    public static void main(String[] args) {
        BST root = new BST(15);
        insert(root, 8);
        insert(root, 35);
        insert(root, 14);
        insert(root, 10);
        insert(root, 12);
        insert(root, 11);
        insert(root, 20);
        insert(root, 42);
        insert(root, 19);
        insert(root, 32);
        insert(root, 28);
        insert(root, 7);
        insert(root, 6);
        insert(root, 5);
        insert(root, 4);
        insert(root, 3);

        System.out.println(inorder(root)); // [3, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19, 20, 28, 32, 35, 42]
        List<Integer> answer = pathWithMostBends(root);
        System.out.println(answer); // [15, 8, 14, 10, 12, 11]
    }
}
