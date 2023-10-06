package util;

public class NodeST<T> {
    private T value;
    private NodeST<T> next;

    public NodeST(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeST<T> getNext() {
        return next;
    }

    public void setNext(NodeST<T> next) {
        this.next = next;
    }
}


