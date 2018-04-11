public class Main {

    public static void main(String[] args) {
        MinHeap myHeap = new MinHeap();
        myHeap.insert(10);
        myHeap.insert(8);
        myHeap.insert(12);
        myHeap.insert(5);
        myHeap.insert(9);
        myHeap.insert(3);
        System.out.println(myHeap.removeHead());
        myHeap.insert(7);
        myHeap.printHeap();
    }
}
