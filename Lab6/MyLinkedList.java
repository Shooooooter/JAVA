public class MyLinkedList<T> {

    private MyNode<T> head = null, tail = null;
    private int size = 0;

    public MyNode<T> getTail() {
        return tail;
    }

    public void setTail(MyNode<T> tail) {
        this.tail = tail;
    }

    public MyNode<T> getHead() {
        return head;
    }

    public void setHead(MyNode<T> head) {
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

    public MyLinkedList() {
    }

    public void add(T nodeValue) {
        MyNode<T> newNode = new MyNode<>(nodeValue);
        if (head == null) {
            head = newNode;
            this.sizeIncrement();

        } else {
            MyNode<T> utilityNode = head;
            while (utilityNode.getNext() != null) {
                utilityNode = utilityNode.getNext();
            }

            utilityNode.setNext(newNode);
            this.sizeIncrement();
            this.setTail(utilityNode);
        }
        this.setCounts();

    }

    public void add(T nodeValue, int position) {
        MyNode<T> newNode = new MyNode<>(nodeValue);

        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            MyNode<T> utilityNode = head;
            for (int i = 0; i < position - 1 && utilityNode.getNext() != null; i++) {
                utilityNode = utilityNode.getNext();
            }

            newNode.setNext(utilityNode.getNext());
            utilityNode.setNext(newNode);
        }

        sizeIncrement();
        setCounts();
    }

    private void setCounts() {
        MyNode<T> listNode = this.getHead();
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

    @Override
    public String toString() {
        MyNode<T> newNode = this.getHead();
        StringBuilder returnString = new StringBuilder();
        while (newNode != null) {
            T data = newNode.getValue();
            int index = newNode.getCount();
            returnString.append("Index: ").append(index).append("\tValue: \n").append(data);
            newNode = newNode.getNext();
        }
        return returnString.toString();
    }

    public MyNode<T> getNodeByIndex(int index) {
        setCounts();
        if (index < 0 || index >= this.getSize()) {
            return null;
        }

        MyNode<T> newNode = this.getHead();

        while (newNode != null) {
            if (newNode.getCount() == index) {
                return newNode;
            } else {
                newNode = newNode.getNext();
            }
        }

        return null;
    }

    public MyNode<T> getNodeByValue(T value) {
        setCounts();
        MyNode<T> newNode = this.getHead();

        while (newNode != null) {
            if (newNode.getValue().equals(value)) {
                return newNode;
            } else {
                newNode = newNode.getNext();
            }
        }

        return null;
    }

    public void del(int index) {
        setCounts();
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        MyNode<T> targetNode = this.getNodeByIndex(index);
        if (index == 0) {
            this.setHead(this.getHead().getNext());
        } else if (index == (this.getSize() - 1)) {
            this.setTail(this.getNodeByIndex((this.getSize() - 2)));
            this.getTail().setNext(null);
        }

        deleteNode(targetNode, index);
        setCounts();
    }

    public void del(T value) {
        setCounts();
        MyNode<T> targetNode = this.getNodeByValue(value);
        MyNode<T> startingNode = this.getHead();
        if (value.equals(startingNode.getValue())) {
            this.setHead(this.getHead().getNext());
        } else if (value.equals(this.getTail().getValue())) {
            MyNode<T> newTail = this.getNodeByIndex(this.getTail().getCount() - 1);
            if (newTail != null) {
                this.setTail(newTail);
                this.getTail().setNext(null);
            }
        }

        deleteNode(targetNode, targetNode.getCount());
        setCounts();
    }

    private void deleteNode(MyNode<T> targetNode, int index) {
        if (targetNode != null) {
            MyNode<T> previousNode = this.getNodeByIndex(index - 1);
            if (previousNode != null) {
                previousNode.setNext(targetNode.getNext());
                sizeDecrement();
            }
        }
    }

    public MyNode<T> getMid() {
        int mid = (this.getSize() / 2) + 1;
        return this.getNodeByIndex(mid);
    }

    public boolean isEmpty() {
        if (this.getSize() == 0) {
            return true;
        }
        return false;
    }

    public void mergeLists(MyLinkedList<T> list2) {
        MyNode<T> ptr1 = this.getTail();
        MyNode<T> ptr2 = list2.getHead();
    
        if (ptr1 != null) {
            ptr1.setNext(ptr2);
            this.setTail(list2.getTail());
            this.setSize(this.getSize() + list2.getSize());
        } else {
            this.setHead(list2.getHead());
            this.setTail(list2.getTail());
            this.setSize(list2.getSize());
        }
        this.setCounts();
    }
    

    public void reverse() {
        MyNode<T> current = head;
        MyNode<T> prev = null;
        MyNode<T> next;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;
        setTail(getNodeByIndex(0));
    }

}