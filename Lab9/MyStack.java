public class MyStack<T> {

    private int top = -1, capacity;
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private Object[] stackArray;

    public MyStack(int size) {
        this.capacity = size;
        this.stackArray = new Object[size];
    }

    public void push(T item) {
        if (this.isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stackArray[++top] = item;
    }

    public int size() {
        return top + 1;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public T pop(T value) {
        MyStack<T> auxStack = new MyStack<>(capacity);
        T removedElement = null;
    
        while (!isEmpty()) {
            T current = pop();
            if (current.equals(value)) {
                removedElement = current;
            } else {
                auxStack.push(current);
            }
        }
    
        while (!auxStack.isEmpty()) {
            push(auxStack.pop());
        }
    
        return removedElement;
    }
    

    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) stackArray[top];
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            result.append(stackArray[i]);
            if (i < top) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}