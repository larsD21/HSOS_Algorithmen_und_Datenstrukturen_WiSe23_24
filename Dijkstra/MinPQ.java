package Dijkstra;

public class MinPQ {
    private PQElement[] pqElements;
    private int maxsize;
    private int currentsize;

    public MinPQ(int max) {
        this.maxsize = max;
        this.currentsize = 0;
        this.pqElements = new PQElement[maxsize];
    }

    public boolean isEmpty() {
        return currentsize == 0;
    }

    public boolean insert(PQElement n) {
        if (currentsize == maxsize) {
            System.err.println("Queue is full");
            return false;
        }
        this.currentsize++;
        int i = currentsize - 1;
        this.pqElements[i] = n;
        while (i > 0 && pqElements[parent(i)].getPriority() > pqElements[i].getPriority()) {
            tausche(i, parent(i));
            i = parent(i);
        }
        return true;
    }

    public boolean insert(String d, double p) {
        return insert(new PQElement(d, p));
    }

    public PQElement extractElement() {
        if (isEmpty()) {
            return null;
        }
        PQElement returnElement = this.pqElements[0];
        this.pqElements[0] = this.pqElements[currentsize - 1];
        this.pqElements[currentsize - 1] = null;
        this.currentsize--;

        minHeapify(0);
        return returnElement;
    }

    public String extractData() {
        if (!isEmpty()) {
            return extractElement().getData();
        } else {
            System.err.println("Heap underflow");
            return null;
        }
    }

    private void minHeapify(int i) {
        int leftChildIndex = left(i);
        int rightChildIndex = right(i);
        int smallest = i;
        if (leftChildIndex < this.currentsize && this.pqElements[leftChildIndex].getPriority() < this.pqElements[smallest].getPriority()) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < this.currentsize && this.pqElements[rightChildIndex].getPriority() < this.pqElements[smallest].getPriority()) {
            smallest = rightChildIndex;
        }
        if (smallest != i) {;
            tausche(i, smallest);
            minHeapify(smallest);
        }
    }

    public void update(String s, double n) {
        for (int i = 0; i < currentsize; i++) {
            if (pqElements[i].getData().equals(s)) {
                if (pqElements[i].getPriority() > n) {
                    pqElements[i].setPriority(n);
                    int index = i;
                    while (index > 0 && pqElements[parent(index)].getPriority() > pqElements[index].getPriority()) {
                        tausche(index, parent(index));
                        index = parent(index);
                    }
                    return;
                }
            }
        }
    }

    private void tausche(int i, int y){
        PQElement temp = this.pqElements[i];
        this.pqElements[i] = this.pqElements[y];
        this.pqElements[y] = temp;
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