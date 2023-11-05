package Praktikum2;

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
            PQElement temp = pqElements[i];
            pqElements[i] = pqElements[parent(i)];
            pqElements[parent(i)] = temp;
            i = parent(i);
        }
        return true;
    }

    public boolean insert(String d, double p) {
        return insert(new PQElement(d, p));
    }

    public PQElement extractElement() {
        if (currentsize == 0) {
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
        PQElement pqElement = extractElement();
        if (pqElement == null) {
            return null;
        } else {
            return pqElement.getData();
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
        if (smallest != i) {
            PQElement temp = this.pqElements[i];
            this.pqElements[i] = this.pqElements[smallest];
            this.pqElements[smallest] = temp;
            minHeapify(smallest);
        }
    }

    public void update(String s, double n){
        int index = -1;
        for (int i = 0; i < currentsize; i++){
            if(pqElements[i].getData().equals(s)){
                index = i;
                break;
            }
        }

        if(index == -1){
            System.err.println("Element not found");
            return;
        }

        if(n >pqElements[index].getPriority()){
            System.err.println("New priority of Element " + pqElements[index].getData() + " is larger or equal");
            return;
        }
        System.out.println("Element: " + s + " changed prio from " + pqElements[index].getPriority() + " to " + n);
        pqElements[index].setPriority(n);
        while (index > 0 && pqElements[parent(index)].getPriority() > pqElements[index].getPriority()) {
            PQElement temp = pqElements[index];
            pqElements[index] = pqElements[parent(index)];
            pqElements[parent(index)] = temp;
            index = parent(index);
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