public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) { list.addLast(item); }
    public T pop() {
        if (list.size() == 0) throw new RuntimeException("Stack is empty");
        T item = list.getLast();
        list.removeLast();
        return item;
    }
    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Stack is empty");
        return list.getLast();
    }
    public boolean isEmpty() { return list.size() == 0; }
}