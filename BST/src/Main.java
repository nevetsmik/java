import java.time.chrono.MinguoChronology;
import java.util.*;

public class Main {

    public static ArrayList<Integer> inOrder(BinaryTree<Integer> node, ArrayList<Integer> list) {
        if (node == null) {
            return list;
        }

        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);

        return list;
    }

    public static List<Integer> preOrder(BinaryTree<Integer> node, List<Integer> result) {
        if (node == null) {
            return result;
        }

        result.add(node.value);
        preOrder(node.left, result);
        preOrder(node.right, result);

        return result;
    }

    public static List<Integer> postOrder(BinaryTree<Integer> node) {
        List<Integer> list = new ArrayList<>();

        if (node == null) {
            return list;
        }

        list.addAll(postOrder(node.left));
        list.addAll(postOrder(node.right));
        list.add(node.value);

        return list;
    }

    public static List<Integer> breadthFirstTraversal(BinaryTree<Integer> node) {
        List<Integer> list = new ArrayList<Integer>();

        Queue<NodeDepth> queue = new ArrayDeque<>();

        NodeDepth nodeAndDepth = new NodeDepth(node, 1);

        queue.add(nodeAndDepth);

        while (queue.size() > 0) {
            NodeDepth current = queue.remove();

            if (current.node.left != null) {
                queue.add(new NodeDepth(current.node.left, current.depth + 1));
            }
            if (current.node.right != null) {
                queue.add(new NodeDepth(current.node.right, current.depth + 1));
            }

            list.add(current.node.value);
        }
        return list;
    }

    public static boolean search(BinaryTree<Integer> node, int target) {
        if (node == null) {
            return false;
        }

        if (node.value == target) {
            return true;
        }

        if (target < node.value) {
            return search(node.left, target);
        } else {
            return search(node.right, target);
        }
    }

    public static BinaryTree<Integer> findNode(BinaryTree<Integer> root, int target) {
        if (root == null) {
            return null;
        }

        if (root.value == target) {
            return root;
        }

        if (target < root.value) {
            return findNode(root.left, target);
        }

        if (target > root.value) {
            return findNode(root.right, target);
        }

        return null;
    }

    public static boolean isBalanced(BinaryTree<Integer> node) {
        List<Integer> depths = new ArrayList<>();

        Queue<NodeDepth> queue = new ArrayDeque<>();

        queue.add(new NodeDepth(node, 1));

        while(queue.size() > 0) {
            NodeDepth current = queue.remove();

            // if the current node has no children
            if (current.node.left == null && current.node.right == null) {
                // add to depths if that level doesn't already exist
                if (!depths.contains(current.depth)) {
                    depths.add(current.depth);
                }
                // if there are more than 2 levels or if one level minus the other is greater than 1
                if (depths.size() > 2) {
                    // return false
                    return false;
                }
                if (depths.size() == 2) {
                    if (Math.abs(depths.get(0) - depths.get(1)) > 1) {
                        return false;
                    }
                }
            } else { // else the current node has children
                // add the children to the queue
                if (current.node.left != null) {
                    queue.add(new NodeDepth(current.node.left, current.depth + 1));
                }
                if (current.node.right != null) {
                    queue.add(new NodeDepth(current.node.right, current.depth + 1));
                }
            }
        }

        return true;
    }

    public static boolean bstChecker(BinaryTree<Integer> node) {
        if (node == null) {
            return false;
        }
        return bstChecker(node, null, null);
    }

    public static boolean bstChecker(BinaryTree<Integer> node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min != null && min > node.value) || (max != null && max < node.value)){
            return false;
        } else {
            return bstChecker(node.left, min, node.value) && bstChecker(node.right, node.value, max);
        }
    }

    public static int longestConsecutiveSequence(BinaryTree<Integer> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + longestConsecutiveSequence(node, node.value);
        }
    }

    public static int longestConsecutiveSequence(BinaryTree<Integer> node, int prevValue) {
        if (node == null) {
            return 0;
        }

        if (node.value == prevValue + 1) {
            return 1 + Math.max(longestConsecutiveSequence(node.left, node.value), longestConsecutiveSequence(node.right, node.value));
        } else {
            return 0 + Math.max(longestConsecutiveSequence(node.left, node.value), longestConsecutiveSequence(node.right, node.value));
        }
    }

    public static List<Integer> longestPath(BinaryTree<Integer> node) {
        return longestPath(node, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public static List<Integer> longestPath(BinaryTree<Integer> node, ArrayList<Integer> currentPath, ArrayList<Integer> finalPath) {
        if (node == null) {
            if (currentPath.size() > finalPath.size()) {
                finalPath = (ArrayList<Integer>)currentPath.clone();
            }
            return finalPath;
        }

        currentPath.add(node.value);

        List<Integer> leftSide = longestPath(node.left, currentPath, finalPath);
        List<Integer> rightSide = longestPath(node.right, currentPath, finalPath);

        currentPath.remove(currentPath.size() - 1);

        return leftSide.size() > rightSide.size() ? leftSide : rightSide;
    }

    public static int getHeight(BinaryTree<Integer> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }

    public static BinaryTree<Integer> insert(BinaryTree<Integer> node, int value) {
        if (node == null) {
            return new BinaryTree<Integer>(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public static int secondLargestValue(BinaryTree<Integer> node) {
        if (node == null || node.right == null) {
            return -1;
        }

        if (node.right.right == null && node.right.left != null) {
            BinaryTree<Integer> secondLargestNode = max(node.right.left);
            return secondLargestNode.value;
        }

        if (node.right.right == null && node.right.left == null) {
            return node.value;
        }

        return secondLargestValue(node.right);
    }

    public static BinaryTree<Integer> max(BinaryTree<Integer> node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public static BinaryTree<Integer> min(BinaryTree<Integer> node) {
        if (node == null) {
            return node;
        }

        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    public static int findClosestValue(BinaryTree<Integer> node, int target) {
        return findClosestValue(node, target, node.value);
    }

    public static int findClosestValue(BinaryTree<Integer> node, int target, int closestValue) {
        if (node == null) {
            return closestValue;
        }

        if (node.value == target) {
            return node.value;
        }

        if (Math.abs(target - node.value) < Math.abs(target - closestValue)) {
            closestValue = node.value;
        }

        if (target < node.value) {
            return findClosestValue(node.left, target, closestValue);
        } else {
            return findClosestValue(node.right, target, closestValue);
        }
    }

    public static BinaryTree<Integer> delete(BinaryTree<Integer> node, int value) {
        if (node == null) {
            return node;
        }

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else if (value == node.value) {
            if (node.left != null && node.right == null) {
                return node.left;
            } else if (node.left == null && node.right != null) {
                return node.right;
            } else if (node.left != null && node.right != null) {
                BinaryTree<Integer> replacement = min(node.right);
                replacement.right = deleteMin(node.right);;
                replacement.left = node.left;
//                System.out.println("Replacement value is: " + replacement);
                return replacement;
            } else if (node.right == null && node.left == null) {
                return null;
            }
        }

        return node;
    }

    public static BinaryTree<Integer> deleteMin(BinaryTree<Integer> node) {
        if (node == null) {
            return node;
        }

        if (node.left == null) {
            if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }

        node.left = deleteMin(node.left);
        return node;
    }

    public static PathWithTurns findPathAndTurns(BinaryTree<Integer> root, BinaryTree<Integer> target) {
        return findPathAndTurns(root, target, new PathWithTurns());
    }

    public static PathWithTurns findPathAndTurns(BinaryTree<Integer> root, BinaryTree<Integer> target, PathWithTurns path) {
        // needs to check that target is in the tree first

        if (root == null) {
            return null;
        }

        if (root == target) {
            path.addNode(root);
            return path;
        }

        if (target.value < root.value) {
            PathWithTurns temp = findPathAndTurns(root.left, target, path);
            if (temp != null) {
                temp.incrementLeft();
                temp.addNode(root);
                return temp;
            }

        }

        if (target.value > root.value) {
            PathWithTurns temp = findPathAndTurns(root.right, target, path);
            if (temp != null) {
                temp.incrementRight();
                temp.addNode(root);
                return temp;
            }
        }

        return null;
    }

    /*
    Draw lines vertical lines down the tree through each node. Get the sum of the nodes on each line.
     */
    public static void verticalSum(BinaryTree<Integer> root) {
        HashMap<Integer, Integer> verticals = new HashMap<>();
        verticals = getVerticals(root, 0, new HashMap<Integer, Integer>());
        System.out.println(verticals.entrySet());
    }

    public static HashMap<Integer, Integer> getVerticals(BinaryTree<Integer> root, int horizontalDistance, HashMap<Integer, Integer> verticals) {
        if (root == null) {
            return verticals;
        }

        getVerticals(root.left, horizontalDistance - 1, verticals);
        int prevSum;

        if(verticals.get(horizontalDistance) == null) {
            prevSum = 0;
        } else {
            prevSum = verticals.get(horizontalDistance);
        }
        verticals.put(horizontalDistance, prevSum + root.value);
        getVerticals(root.right, horizontalDistance + 1, verticals);

        return verticals;
    }


    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(20);
//        insert(root, 10);
//        insert(root, 30);
//        insert(root, 5);
//        insert(root, 15);
//        insert(root, 25);
//        insert(root, 35);
//        insert(root, 3);
//        insert(root, 7);
//        insert(root, 13);
//        insert(root, 17);
//        insert(root, 27);
//        insert(root, 32);
//        insert(root, 36);
//        insert(root, 12);
        BinaryTree<Integer> branch1 = root.insertLeft(10);
        BinaryTree<Integer> branch2 = root.insertRight(30);
        BinaryTree<Integer> branch3 = branch1.insertLeft(5);
        BinaryTree<Integer> branch4 = branch1.insertRight(15);
        BinaryTree<Integer> branch5 = branch2.insertLeft(25);
        BinaryTree<Integer> branch6 = branch2.insertRight(35);
        BinaryTree<Integer> branch7 = branch3.insertLeft(3);
        BinaryTree<Integer> branch8 = branch3.insertRight(7);
        BinaryTree<Integer> branch9 = branch4.insertLeft(13);
        BinaryTree<Integer> branch10 = branch4.insertRight(17);
        BinaryTree<Integer> branch11 = branch5.insertRight(27);
        BinaryTree<Integer> branch12 = branch6.insertLeft(32);
        BinaryTree<Integer> branch13 = branch6.insertRight(36);
        BinaryTree<Integer> branch14 = branch9.insertLeft(12);

        BinaryTree<Integer> branch15 = branch13.insertRight(37);
        BinaryTree<Integer> branch16 = branch15.insertRight(38);


        // inOrder traversal
        List<Integer> listInOrder = inOrder(root, new ArrayList<Integer>());
        System.out.println(Arrays.toString(listInOrder.toArray()));

        // preOrder traversal
        List<Integer> listPreOrder = preOrder(root, new ArrayList<Integer>());
        System.out.println(Arrays.toString(listPreOrder.toArray()));

        // postOrder traversal
        List<Integer> listPostOrder = postOrder(root);
        System.out.println(Arrays.toString(listPostOrder.toArray()));

        // breadth first traversal
        List<Integer> breadthFirst = breadthFirstTraversal(root);
        System.out.println(Arrays.toString(breadthFirst.toArray()));

        int target = 36;
        boolean found = search(root, target);
        System.out.println("Is " + target + " in the tree? " + found);

        // isBalanced
        System.out.println("root isBalanced?: " + isBalanced(root));

        // bstChecker
        System.out.println("root is a bst? " + bstChecker(root));

        // longestConsecutiveSequence
        System.out.println("longest consecutive sequence is: " + longestConsecutiveSequence(root));

        // longestPath
        List<Integer> result = longestPath(root);
        System.out.println("Longest path in tree is: " + Arrays.toString(result.toArray()));

        // secondLargest
        System.out.println("The second largest value is: " + secondLargestValue(root));

        // closestValue
        target = 16;
        System.out.println("The closest value to " + target + " is: " + findClosestValue(root, target));

        // delete
        delete(root, 30);
        listInOrder = inOrder(root, new ArrayList<Integer>());
        System.out.println(Arrays.toString(listInOrder.toArray()));

        BinaryTree<Integer> foundNode = findNode(root, 7);
        if (foundNode == null) {
            System.out.println("Node not found");
        } else {
            System.out.println("Found node: " + foundNode.toString());
        }

        PathWithTurns answer = findPathAndTurns(branch4, branch14);
        System.out.println("Nodes: " + answer.printNodes());
        System.out.println("Turns: " + answer.printTurns());

        verticalSum(root);
    }
}
