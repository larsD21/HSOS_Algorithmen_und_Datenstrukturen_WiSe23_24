package Datastructures;

public class PriorityQueue {
    private int[] A;
    private int size;

    public PriorityQueue(int capacity) {
        this.A = new int[capacity];
        this.size = 0;
    }

    public int extractMax() throws Exception {
        if (size < 1) {
            throw new Exception("Priority Queue is empty");
        }
        int max = A[0];
        A[0] = A[size - 1];
        size--;
        maxHeapify(0);
        return max;
    }

    public void insertNew(int newElement) throws Exception {
        if (size == A.length) {
            throw new Exception("Priority Queue is full");
        }
        size++;
        int i = size - 1;
        A[i] = newElement;
        while (i > 0 && A[parent(i)] < A[i]) {
            int temp = A[i];
            A[i] = A[parent(i)];
            A[parent(i)] = temp;
            i = parent(i);
        }
    }

    private void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size && A[l] > A[i]) {
            largest = l;
        }
        if (r < size && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(largest);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }
}
