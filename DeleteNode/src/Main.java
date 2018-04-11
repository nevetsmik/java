
public class Main {

    public static void deleteNode(LinkedListNode node) {
        LinkedListNode next = node.next;
        node.value = next.value;
        node.next = next.next;
    }

    public static void print(LinkedListNode node) {
        LinkedListNode iter = node;

        while (iter != null) {
            System.out.print(iter.value);
            if (iter.next != null) {
                System.out.print(" -> ");
            }
            iter = iter.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
	    LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");
        LinkedListNode c = new LinkedListNode("C");

        a.next = b;
        b.next = c;
        print(a);

        deleteNode(b);

        print(a);
    }
}
