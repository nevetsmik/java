public class LinkedList {
    public LinkedListNode head;
    public LinkedListNode tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedListNode addToHead(int value) {
        LinkedListNode newNode = new LinkedListNode(value);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        return newNode;
    }

    public void removeHead() {
        this.head = this.head.next;
    }

    public LinkedListNode addToTail(int value) {
        LinkedListNode newNode = new LinkedListNode(value);

        this.tail.next = newNode;
        this.tail = newNode;
        return newNode;
    }

    public void removeTail() {
        LinkedListNode itr = this.head;

        while(itr.next != this.tail) {
            itr = itr.next;
        }

        itr = null;
        this.tail = itr;
    }

    public void print() {
        LinkedListNode itr = this.head;
        while (itr != null) {
            System.out.println(itr.value + " -> ");
            itr = itr.next;
            if (itr == null) {
                System.out.println("null");
            }
        }
    }
}
