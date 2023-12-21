import java.util.LinkedList;

public class MyLLStack<T> {

    private LinkedList<T> stackList;

    public MyLLStack() {
        this.stackList = new LinkedList<>();
    }

    public void push(T item) {
        stackList.push(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackList.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackList.peek();
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    @Override
    public String toString() {
        return stackList.toString();
    }
}
