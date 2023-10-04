package util;

public class HNode<K,V> implements INode {
    private V value;
    private K key;
    private HNode<K,V> nextNode;
    private HNode<K,V> previousNode;

    public HNode(K key, V value){
        this.value = value;
        this.key = key;
        this.nextNode=null;
        this.previousNode=null;
    }

    public HNode<K, V> getNextNode() {
        return nextNode;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setNextNode(HNode<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public HNode<K, V> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(HNode<K, V> previous) {
        this.previousNode = previous;
    }
}

