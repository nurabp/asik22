public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) { list.addLast(item); }
    public T dequeue() {
        if (list.size() == 0) throw new RuntimeException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Queue is empty");
        return list.getFirst();
    }
    public boolean isEmpty() { return list.size() == 0; }
}
