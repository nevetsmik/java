import java.util.LinkedList;

public class Main {

    public static LinkedListNode deepCopyLL(LinkedListNode node) {
        LinkedListNode itr = node;
        LinkedListNode newHead = new LinkedListNode(node.value);
        LinkedListNode itrForNewList = newHead;

        while (itr.next != null) {
            itrForNewList.next = new LinkedListNode(itr.next.value);
            itr = itr.next;
            itrForNewList = itrForNewList.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
	LinkedListNode a = new LinkedListNode(1);
	LinkedListNode b = new LinkedListNode(2);
	LinkedListNode c = new LinkedListNode(3);

	a.next = b;
	b.next = c;

    LinkedListNode result = deepCopyLL(a);
    System.out.println(a == result);
    }
}
