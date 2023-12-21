public class StackQueue<T> {
    private MyStack<T> s1;
    private MyStack<T> s2;

    public StackQueue() {
        s1 = new MyStack<>(500);
        s2 = new MyStack<>(500);
    }

    public void push(T x) {
        s1.push(x);
    }

    public T pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            return null;
        }

        return s2.pop();
    }

    @Override
    public String toString() {
        return  s1.toString() +
                s2.toString();
    }

}
