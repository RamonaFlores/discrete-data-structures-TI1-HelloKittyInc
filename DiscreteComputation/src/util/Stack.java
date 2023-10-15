package util;  // Package declaration for the util package.
import java.util.EmptyStackException;
/**
 * The Stack class represents a generic stack data structure.
 * It allows you to perform typical stack operations such as push, pop, top, and check for emptiness.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class Stack<T> implements IStack<T> {
    private NodeST<T> top;  // Attribute to keep track of the top element in the stack.
    /**
     * Retrieves the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T top() {
        if (isEmpty()) {  // Check if the stack is empty.
            throw new EmptyStackException();  // Throw an exception if the stack is empty.
        }
        return top.getValue();  // Return the value of the top element.
    }
    /**
     * Checks whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return top == null;  // Return true if the top element is null (indicating an empty stack).
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T pop() {
        if (isEmpty()) {  // Check if the stack is empty.
            throw new EmptyStackException();  // Throw an exception if the stack is empty.
        }
        NodeST<T> newTop = top.getNext();  // Get the next element in the stack.
        T topValue = top.getValue();  // Get the value of the current top element.
        top.setNext(null);  // Set the next reference of the current top to null.
        top = newTop;  // Update the top to the new top element.
        return topValue;  // Return the value of the removed top element.
    }

    /**
     * Adds a new element to the top of the stack.
     *
     * @param value The element to be added to the stack.
     */
    @Override
    public void push(T value) {
        // Create a new node containing the specified value
        NodeST<T> newTop = new NodeST<>(value);

        if (top == null) {
            // If the stack is empty, set the new node as the top
            top = newTop;
        } else {
            // If the stack is not empty, link the new node to the current top and update the top reference
            newTop.setNext(top);
            top = newTop;
        }
    }
    @Override
    public String toString() {
        return "Stack. " +
                "top: " + top;
    }
}
