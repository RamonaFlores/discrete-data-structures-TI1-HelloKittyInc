package util;

import model.Task;

public class MaxHeap <V> implements MaxPriorityQueueI<V> {
    private NodePQ <V> [] maxHeap;
    private int heapSize;

    public MaxHeap(int heapSize){
        maxHeap = new NodePQ[heapSize];
    }
    public void heapify(NodePQ data) {
        if (heapSize == maxHeap.length) {
            throw new IllegalStateException("MaxHeap full");
        } else {
            int actual = heapSize;
            maxHeap[actual] = data;
            heapSize++;
            // Llamar a maxHeapify para ajustar el montículo
            maxHeapify(actual, heapSize);
        }
    }

    public void maxHeapify(int i, int heapSize) {
        int largest = i;
        int leftChild = 2 * i + 1;  // Índice del hijo izquierdo
        int rightChild = 2 * i + 2; // Índice del hijo derecho

        // Comprobar si el hijo izquierdo existe y es mayor que el nodo actual
        if (leftChild < heapSize && maxHeap[leftChild].getPriorityValue() > maxHeap[largest].getPriorityValue()) {
            largest = leftChild;
        }
        // Comprobar si el hijo derecho existe y es mayor que el nodo actual o el hijo izquierdo
        if (rightChild < heapSize && maxHeap[rightChild].getPriorityValue() > maxHeap[largest].getPriorityValue()) {
            largest = rightChild;
        }
        
        // Si el nodo más grande no es el nodo actual, intercambiar y recursivamente llamar a maxHeapify
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest, heapSize);
        }
    }
    public void swap(int i, int j) {
        NodePQ temp = maxHeap[i];
        maxHeap[i] = maxHeap[j];
        maxHeap[j] = temp;
    }
    public String printArray(){
        String message = "";
        for (NodePQ obj: maxHeap) {
            message += obj + "\n";
        }
        return message;
    }

    @Override
    public void insert(int key, V element) {
        NodePQ<V> nodePQ = new NodePQ<V>(element, key);

        if (heapSize == maxHeap.length) {
            throw new IllegalStateException("MaxHeap full");
        } else {
            int actual = heapSize;
            maxHeap[actual] = nodePQ;
            heapSize++;
            // Llamar a maxHeapify para ajustar el montículo
            maxHeapify(actual, heapSize);
        }
    }


    @Override
    public V maximun() {
        return null;
    }

    @Override
    public V extractMax() {
        return null;
    }

    @Override
    public void increaseKey(int newKey, Object element) {

    }
}
