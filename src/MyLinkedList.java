public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next, prev;
        MyNode(T data) { this.data = data; }
    }

    private MyNode head, tail;
    private int size = 0;

    public void add(T item) { addLast(item); }
    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    public void addLast(T item) {
        MyNode node = new MyNode(item);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    public void add(int index, T item) {
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            checkIndexForAdd(index);
            MyNode current = getNode(index);
            MyNode node = new MyNode(item);
            node.prev = current.prev;
            node.next = current;
            current.prev.next = node;
            current.prev = node;
            size++;
        }
    }
    public void set(int index, T item) { checkIndex(index); getNode(index).data = item; }
    public T get(int index) { checkIndex(index); return getNode(index).data; }
    public T getFirst() { return head.data; }
    public T getLast() { return tail.data; }
    public void remove(int index) { checkIndex(index); unlink(getNode(index)); }
    public void removeFirst() { if (head != null) unlink(head); }
    public void removeLast() { if (tail != null) unlink(tail); }

    private void unlink(MyNode node) {
        if (node.prev == null) head = node.next;
        else node.prev.next = node.next;
        if (node.next == null) tail = node.prev;
        else node.next.prev = node.prev;
        size--;
    }

    private MyNode getNode(int index) {
        MyNode current = index < size / 2 ? head : tail;
        if (index < size / 2)
            for (int i = 0; i < index; i++) current = current.next;
        else
            for (int i = size - 1; i > index; i--) current = current.prev;
        return current;
    }

    public void sort() {
        Object[] arr = toArray();
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (((T)arr[j]).compareTo((T)arr[j+1]) > 0) {
                    Object tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
        MyNode current = head;
        for (Object o : arr) { current.data = (T) o; current = current.next; }
    }

    public int indexOf(Object o) {
        MyNode c = head;
        for (int i = 0; c != null; i++) { if (c.data.equals(o)) return i; c = c.next; }
        return -1;
    }
    public int lastIndexOf(Object o) {
        MyNode c = tail;
        for (int i = size - 1; c != null; i--) { if (c.data.equals(o)) return i; c = c.prev; }
        return -1;
    }
    public boolean exists(Object o) { return indexOf(o) != -1; }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode c = head; int i = 0;
        while (c != null) { arr[i++] = c.data; c = c.next; }
        return arr;
    }
    public void clear() { head = tail = null; size = 0; }
    public int size() { return size; }
    private void checkIndex(int index) { if (index < 0 || index >= size) throw new IndexOutOfBoundsException(); }
    private void checkIndexForAdd(int index) { if (index < 0 || index > size) throw new IndexOutOfBoundsException(); }
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            MyNode current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
