public class MyDoublyNode<T> {
    int count;
    T value;
    MyDoublyNode<T> next;
    MyDoublyNode<T> previous;

    public MyDoublyNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(MyDoublyNode<T> previous) {
        this.previous = previous;
    }

    public void setNext(MyDoublyNode<T> next) {
        this.next = next;
    }

    public MyDoublyNode(T userValue) {
        this.setValue(userValue);
        this.setNext(null);
        this.setPrevious(null);
    }

    public MyDoublyNode(T userValue, MyDoublyNode<T> userNextNode, int nodeCount) {
        this.setValue(userValue);
        this.next = userNextNode;
        this.setPrevious(null);
        this.setCount(nodeCount);
    }

    public T getValue() {
        return value;
    }

    public MyDoublyNode() {

    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public MyDoublyNode<T> getNext() {
        return this.next;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Index: " + this.count + "\n" +
                "Value: " + this.getValue().toString() + "\n");

        if (this.previous != null) {
            result.append("Previous: ").append(this.previous.getValue().toString()).append("\n");
        } else {
            result.append("Previous: null\n");
        }

        if (this.next != null) {
            result.append("Next: ").append(this.next.getValue().toString()).append("\n");
        } else {
            result.append("Next: null\n");
        }

        return result.toString();
    }

}