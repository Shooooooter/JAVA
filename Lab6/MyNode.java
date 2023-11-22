public class MyNode<T> {
    int count;
    T value;
    MyNode<T> next;

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode(T userValue) {
        this.setValue(userValue);
        this.setNext(null);
    }

    public MyNode(T userValue, MyNode<T> userNextNode, int nodeCount) {
        this.setValue(userValue);
        this.next = userNextNode;
        this.setCount(nodeCount);
    }

    public T getValue() {
        return value;
    }

    public MyNode() {

    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public MyNode<T> getNext() {
        return this.next;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return ("Index: " + this.count + "\n" + this.getValue().toString());
    }

}