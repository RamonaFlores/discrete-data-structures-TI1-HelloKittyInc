package util;
import java.util.ArrayList;

public class MaxHeap<T> implements MaxPriorityQueueI<T> {
    private ArrayList<NodePQ<T>> PQ;

    public MaxHeap() {
        PQ = new ArrayList<>();
    }
    /**
     *This method is used to maintain the Max Heap property by comparing
     * the priorities of the current node and its children, and rearranging the elements
     * if necessary to ensure that the node with the maximum priority is at the root of the Max Heap.
     * The method operates recursively to maintain this property throughout the heap.
     *
     * @param index The index at which to apply the Max-Heapify operation.
     */
    public void maxHeapify(int index) {

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int max = index;

        if (left < PQ.size() && PQ.get(left).getPriorityValue() > PQ.get(index).getPriorityValue()) {
            max = left;
        }
        if (right < PQ.size() && PQ.get(right).getPriorityValue() > PQ.get(index).getPriorityValue()) {
            max = right;
        }
        //If max is equals to index is because the index already sort in the first position or root, otherwise
        //we do the exchange
        if (max != index) {
            NodePQ tempMax = PQ.get(max);
            NodePQ tempMin = PQ.get(index);

            PQ.set(max, tempMin);
            PQ.set(index, tempMax);

            //We make the method recursivity to ensure than the object with major priority ends in the first position or root
            maxHeapify(max);
        }
    }
    /**
     * Builds a Max Heap from the current array of elements.
     * This method rearranges the elements in the array to satisfy the Max Heap property.
     * It iterates through the array starting from the middle and calls the maxHeapify
     * operation for each element, ensuring that the Max Heap property is maintained.
     */
    public void buildMaxHeap() {
        for (int i = PQ.size() / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }
    /**
     * Inserts a new element with a specified priority key into the Max Priority Queue.
     *
     * @param key     The priority key associated with the element to be inserted.
     * @param element The element to be added to the Max Priority Queue.
     */
    @Override
    public void insert(int key, T element) {
        PQ.add(new NodePQ<T>(element, key));
        buildMaxHeap();
    }
    /**
     * Returns the element with the highest priority in the
     * Max Priority Queue without removing it.
     *
     * @return The element with the highest priority in the Max Priority Queue.
     */
    @Override
    public T maximum() {
        return PQ.get(0).getValue();
    }
    /**
     * Removes and returns the element with the highest priority from the Max Priority Queue.
     *
     * @return The element with the highest priority that has been removed
     * from the Max Priority Queue.
     */
    @Override
    public T extractMax() {
        String message = "";
        if (PQ.size() < 2) {
            message = "heap underflow";
        }
        T max = PQ.get(0).getValue();
        PQ.set(0, PQ.get(PQ.size() - 1));
        PQ.remove(PQ.size() - 1);
        maxHeapify(0);
        return max;
    }
    /**
     * Increases the key of a specific element in the priority queue. This method is used
     * to update the priority of an element while maintaining the max-heap property.
     *
     * @param key The new priority value for the element.
     * @param element The element for which the priority is to be updated.
     * @throws IllegalArgumentException if the new key is smaller than the current key.
     */
    @Override
    public void increaseKey(int key, T element) {
        int index = -1;
        // Find the index of the element in the priority queue
        for (int i = 0; i < PQ.size(); i++) {
            if (PQ.get(i).getValue() == element) {
                index = i;
            }
        }
        // Check if the new key is smaller than the current key, which is not allowed in a max-heap
        if (key < PQ.get(index).getPriorityValue()) {
            throw new IllegalArgumentException("New key is smaller than the current key");
        }
        // Update the priority value of the element
        PQ.get(index).setPriorityValue(key);

        // Maintain the max-heap property by repeatedly comparing the element with its parent
        while (index > 1 && PQ.get(parent(index)).getPriorityValue() < PQ.get(index).getPriorityValue()) {
            // Exchange the key values of the element and its parent
            int temp = PQ.get(index).getPriorityValue();
            PQ.get(index).setPriorityValue(PQ.get(parent(index)).getPriorityValue());
            PQ.get(parent(index)).setPriorityValue(temp);
            index = parent(index);
        }
    }
    public int parent(int i) {
        return i / 2;
    }
    /**
     * Returns a string representation of the elements in the Max Priority Queue.
     *
     * @return A string containing the values of the elements in the Max Priority Queue,
     * each on a new line.
     */
    public String printArray() {
        String priorityQueue = "";
        for (int i = 0; i < PQ.size(); i++) {
            priorityQueue +=  "" + PQ.get(i).getPriorityValue() + "\n" ;
        }
        return priorityQueue;
    }
}