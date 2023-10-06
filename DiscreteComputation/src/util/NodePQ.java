package util;

public class NodePQ <T> {
    private T value;
    private int priorityValue;

    public NodePQ(T value, int priorityValue) {
        this.value = value;
        this.priorityValue = priorityValue;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public int getPriorityValue() {
        return priorityValue;
    }
    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    @Override
    public String toString() {
        return "NodePQ{" +
                "priorityValue: " + priorityValue + "\n"+
                "value: " + value +
                "\n";
    }
}
