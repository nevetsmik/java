public class Main {

    public static boolean containsCycle(LinkedListNode node) {
        LinkedListNode slow = node;
        LinkedListNode fast = node;

        while (fast != null) {
            fast = jumpAhead(fast, 2);
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static LinkedListNode jumpAhead(LinkedListNode node, int numJumps) {
        int i = 0;

        LinkedListNode itr = node;
        while (i < numJumps) {
            itr = itr.next;
            if (node == null) {
                return null;
            }
            i++;
        }
        return itr;
    }



    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");
        LinkedListNode c = new LinkedListNode("C");
        LinkedListNode d = new LinkedListNode("D");
        LinkedListNode e = new LinkedListNode("E");
        LinkedListNode f = new LinkedListNode("F");
        LinkedListNode g = new LinkedListNode("G");
        LinkedListNode h = new LinkedListNode("H");
        LinkedListNode i = new LinkedListNode("I");




    }
}
