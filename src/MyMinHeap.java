public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void insert(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    public T extractMin() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty");
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.removeLast();
        siftDown(0);
        return min;
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parent)) < 0) {
                T tmp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, tmp);
                i = parent;
            } else break;
        }
    }

    private void siftDown(int i) {
        int left = 2 * i + 1, right = 2 * i + 2, smallest = i;
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) smallest = left;
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) smallest = right;
        if (smallest != i) {
            T tmp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, tmp);
            siftDown(smallest);
        }
    }

    public boolean isEmpty() { return heap.size() == 0; }
}
