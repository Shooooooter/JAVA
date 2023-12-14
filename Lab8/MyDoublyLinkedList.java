import java.util.HashMap;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<T extends Comparable<T>> {

    private MyDoublyNode<T> head = null, tail = null;
    private int size = 0;
    private final int capacity;
    private HashMap<T, MyDoublyNode<T>> cache = new HashMap<>();

    public MyDoublyLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public MyDoublyNode<T> getTail() {
        return tail;
    }

    public void setTail(MyDoublyNode<T> tail) {
        this.tail = tail;
    }

    public MyDoublyNode<T> getHead() {
        return head;
    }

    public void setHead(MyDoublyNode<T> head) {
        this.head = head;
    }

    public int getSize() {
        this.setCounts();
        return size;
    }

    private void setSize(int size) {
        this.size = size;
        this.setCounts();
    }

    private void sizeIncrement() {
        this.setSize(this.getSize() + 1);
    }

    private void sizeDecrement() {
        this.setSize(this.getSize() - 1);
    }

    public void addLast(T nodeValue) {
        MyDoublyNode<T> newNode = new MyDoublyNode<>(nodeValue);
        addToCache(newNode);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        this.sizeIncrement();
        this.setCounts();
    }

    public void addFirst(T nodeValue) {
        MyDoublyNode<T> newNode = new MyDoublyNode<>(nodeValue);
        addToCache(newNode);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }

        this.sizeIncrement();
        this.setCounts();
    }

    public void add(T nodeValue, int position) {
        MyDoublyNode<T> newNode = new MyDoublyNode<>(nodeValue);
        addToCache(newNode);

        if (position == 0) {
            if (head != null) {
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
            } else {
                this.setHead(newNode);
                this.setTail(newNode);
            }
        } else {
            MyDoublyNode<T> utilityNode = head;
            for (int i = 0; i < position - 1 && utilityNode.getNext() != null; i++) {
                utilityNode = utilityNode.getNext();
            }

            newNode.setNext(utilityNode.getNext());
            newNode.setPrevious(utilityNode);
            if (utilityNode.getNext() != null) {
                utilityNode.getNext().setPrevious(newNode);
            }
            utilityNode.setNext(newNode);
        }

        this.sizeIncrement();
        this.setCounts();
    }

    private void setCounts() {
        MyDoublyNode<T> listNode = this.getHead();
        int nodeCount = 0;
        while (listNode != null) {
            listNode.setCount(nodeCount);
            nodeCount++;
            if (listNode.getNext() == null) {
                break;
            } else {
                listNode = listNode.getNext();
            }
        }
    }

    public MyDoublyNode<T> getNodeByIndex(int index) {
        this.setCounts();
        if (index < 0 || index >= this.getSize()) {
            return null;
        }

        MyDoublyNode<T> newNode = this.getHead();

        while (newNode != null) {
            if (newNode.getCount() == index) {
                addToCache(newNode);
                return newNode;
            } else {
                newNode = newNode.getNext();
            }
        }

        return null;
    }

    public MyDoublyNode<T> getNodeByValue(T value) {
        this.setCounts();

        MyDoublyNode<T> result = this.get(value);

        if (result == null) {
            MyDoublyNode<T> newNode = this.getHead();
            while (newNode != null) {

                if (newNode.getValue().equals(value)) {
                    addToCache(newNode);
                    return newNode;
                } else {
                    newNode = newNode.getNext();
                }
            }
        }

        return result;
    }

    public void del(int index) {
        setCounts();
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        MyDoublyNode<T> targetNode = this.getNodeByIndex(index);
        if (index == 0) {
            this.setHead(targetNode.getNext());
            if (this.getHead() != null) {
                this.getHead().setPrevious(null);
            }
        } else if (index == (this.getSize() - 1)) {
            this.setTail(this.getNodeByIndex(index - 1));
            if (this.getTail() != null) {
                this.getTail().setNext(null);
            }
        } else {
            MyDoublyNode<T> previousNode = targetNode.getPrevious();
            MyDoublyNode<T> nextNode = targetNode.getNext();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
        }

        deleteNode(targetNode, index);
        this.setCounts();
    }

    public void del(T value) {
        setCounts();
        MyDoublyNode<T> targetNode = this.getNodeByValue(value);

        if (targetNode != null) {
            MyDoublyNode<T> previousNode = targetNode.getPrevious();
            MyDoublyNode<T> nextNode = targetNode.getNext();

            if (previousNode != null) {
                previousNode.setNext(nextNode);
            } else {
                this.setHead(nextNode);
                if (this.getHead() != null) {
                    this.getHead().setPrevious(null);
                }
            }

            if (nextNode != null) {
                nextNode.setPrevious(previousNode);
            } else {
                this.setTail(previousNode);
                if (this.getTail() != null) {
                    this.getTail().setNext(null);
                }
            }

            deleteNode(targetNode, targetNode.getCount());
            this.setCounts();
        }
    }

    private void deleteNode(MyDoublyNode<T> targetNode, int index) {
        if (targetNode != null) {
            MyDoublyNode<T> previousNode = this.getNodeByIndex(index - 1);
            MyDoublyNode<T> nextNode = targetNode.getNext();

            if (previousNode != null) {
                previousNode.setNext(nextNode);
            }

            if (nextNode != null) {
                nextNode.setPrevious(previousNode);
            } else {
                this.setTail(previousNode);
            }
            this.sizeDecrement();
        }
    }

    public MyDoublyNode<T> getMid() {
        int mid = (this.getSize() / 2);
        addToCache(this.getNodeByIndex(mid));
        return this.getNodeByIndex(mid);
    }

    public boolean isEmpty() {
        if (this.getSize() == 0) {
            return true;
        }
        return false;
    }

    private void moveNodeToFront(MyDoublyNode<T> accessedNode) {
        if (accessedNode != this.getHead()) {
            MyDoublyNode<T> previousNode = accessedNode.getPrevious();
            MyDoublyNode<T> nextNode = accessedNode.getNext();

            if (previousNode != null) {
                previousNode.setNext(nextNode);
            } else {
                tail = nextNode;
            }

            if (nextNode != null) {
                nextNode.setPrevious(previousNode);
            }

            accessedNode.setPrevious(null);
            accessedNode.setNext(head);
            head.setPrevious(accessedNode);

            head = accessedNode;
        }
    }

    private void addToCache(MyDoublyNode<T> newNode) {
        if (cache.size() >= capacity) {
            MyDoublyNode<T> lruNode = tail;
            cache.remove(lruNode.getValue());
            deleteNode(lruNode, lruNode.getCount());
        }

        cache.put(newNode.getValue(), newNode);
    }

    public MyDoublyNode<T> get(T value) {
        MyDoublyNode<T> result = cache.get(value);
        if (result != null) {
            moveNodeToFront(result);
        }
        return result;
    }

    public void sort() {
        if (head == null || head.getNext() == null) {
            return;
        }

        boolean swapped;
        MyDoublyNode<T> current;
        MyDoublyNode<T> last = null;

        do {
            swapped = false;
            current = head;

            while (current.getNext() != last) {
                MyDoublyNode<T> nextNode = current.getNext();
                if (current.getValue().compareTo(nextNode.getValue()) > 0) {
                    swapNodes(current, nextNode);
                    swapped = true;
                }
                current = current.getNext();
            }

            last = current;
        } while (swapped);
    }

    private void swapNodes(MyDoublyNode<T> first, MyDoublyNode<T> second) {
        T temp = first.getValue();
        first.setValue(second.getValue());
        second.setValue(temp);
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        T removedValue = head.getValue();
        head = head.getNext();

        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }

        sizeDecrement();
        this.setCounts();
        return removedValue;
    }

    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }

        T removedValue = tail.getValue();
        tail = tail.getPrevious();

        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }

        sizeDecrement();
        this.setCounts();
        return removedValue;
    }

    @Override
    public String toString() {
        MyDoublyNode<T> newNode = this.getHead();
        StringBuilder returnString = new StringBuilder();
        while (newNode != null) {
            returnString.append(newNode.toString()).append("\n");
            newNode = newNode.getNext();
        }
        return returnString.toString();
    }

}