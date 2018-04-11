package LargestConsecutivePath;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        Tree root = new Tree(1);
//        Tree branch1 = root.insertLeft(2);
//        Tree branch2 = root.insertRight(4);
//        Tree branch3 = branch1.insertLeft(3);
//        Tree branch4 = branch2.insertLeft(5);
//        Tree branch5 = branch2.insertRight(6);
//        Tree branch6 = branch5.insertLeft(7);

        Tree root = new Tree(6);
        Tree branch1 = root.insertRight(7);
        Tree branch2 = branch1.insertLeft(9);
        Tree branch3 = branch1.insertRight(10);
        Tree branch4 = branch3.insertRight(12);

        ArrayList<Tree> answer = root.traverseDFInOrder(root);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i).getValue());
            if (i < answer.size() - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        int largestConsecutivePath = root.largestConsecutivePath(root);
        System.out.println("largestConsecutivePath: " + largestConsecutivePath);

    }
}
