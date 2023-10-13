package util;

public interface MaxPriorityQueueI<V> {
    public void insert(int key, V element);

    public V maximum();

    public V extractMax();

    public void increaseKey(int newKey, V element);

}