package util;

import java.util.EmptyStackException;

public class Stack<T> implements IStack<T> {

    private NodeST<T> top;

    public Stack() {
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        NodeST<T> newTop = top.getNext();
        T topValue = top.getValue();
        top.setNext(null);
        top = newTop;
        return topValue;
    }

    @Override
    public void push(T value) {
        NodeST<T> newTop = new NodeST<>(value);

        if (top == null) {
            top = newTop;
        } else {
            newTop.setNext(top);
            top = newTop;
        }
    }
}
