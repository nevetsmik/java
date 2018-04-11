import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap {

    public ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<Integer>();
    }

    public Integer removeHead() {
        // Swap the first and last
        swap(0, this.heap.size() - 1);
        int oldHead = this.heap.remove(this.heap.size() - 1);

        // Bubble down the parent
        bubbleDown();

        // Remove and return last element from the list
        return oldHead;
    }

    public void insert(Integer value) {
        this.heap.add(value);
        bubbleUp();
    }

    public Integer peekFirst() {
        return this.heap.get(0);
    }

    public Integer peekLast() {
        return this.heap.get(this.heap.size() - 1);
    }

    public void printHeap() {
        System.out.println(this.heap);
    }

    private void swap(int x, int y) {
        Integer temp = this.heap.get(x);
        this.heap.set(x, this.heap.get(y));
        this.heap.set(y, temp);
    }

    private void bubbleDown() {
        // get the parent value
        Integer parentIndex = 0;
        Integer parentValue = this.heap.get(parentIndex);
        // get the smallestChild Value
        Integer smallestChildIndex = this.getSmallestChild(parentIndex);
        Integer childValue = this.heap.get(smallestChildIndex);

        while (parentValue > childValue) {
            swap(parentIndex, smallestChildIndex);
            parentIndex = smallestChildIndex;
            parentValue = this.heap.get(parentIndex);
            smallestChildIndex = this.getSmallestChild(parentIndex);
            childValue = this.heap.get(smallestChildIndex);
        }
    }

    private void bubbleUp() {
        // get the last value at the end of the heap
        Integer childIndex = this.heap.size() - 1;
        Integer childValue = this.heap.get(childIndex);
        // get the parent value
        Integer parentIndex = this.getParent(childIndex);
        Integer parentValue = this.heap.get(parentIndex);

        while(childValue < parentValue) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            childValue = this.heap.get(childIndex);
            parentIndex = this.getParent(childIndex);
            parentValue = this.heap.get(parentIndex);
        }
    }

    private Integer getParent(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private ArrayList<Integer> getChildren(int parentIndex) {
        ArrayList<Integer> children = new ArrayList<Integer>();
        int leftChild = (parentIndex * 2) + 1;
        int rightChild = (parentIndex * 2) + 2;
        if (leftChild < this.heap.size()) {
            children.add(leftChild);
        }
        if (rightChild < this.heap.size()) {
            children.add(rightChild);
        }
        return children;
    }

    private Integer getSmallestChild(int parentIndex) {
        ArrayList<Integer> children = getChildren(parentIndex);
        if (children.size() == 0) {
            return parentIndex;
        } else if (children.size() == 1) {
            return children.get(0);
        }
        int leftChildIndex = children.get(0);
        int rightChildIndex = children.get(1);
        if (this.heap.get(leftChildIndex) < this.heap.get(rightChildIndex)) {
            return leftChildIndex;
        }
        return rightChildIndex;
    }
}