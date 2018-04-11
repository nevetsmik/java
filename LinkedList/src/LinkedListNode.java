public class LinkedListNode {
    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
        this.next = null;
    }

    public LinkedListNode add(String value) {
        LinkedListNode newNode = new LinkedListNode(value);
        newNode.next = this.next;
        this.next = newNode;
        return newNode;
    }
}
