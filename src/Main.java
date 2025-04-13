public class Main {
    public static void main(String[] args) {
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("MyArrayList:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }

        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println("\n\nMyLinkedList:");
        for (String s : linkedList) {
            System.out.print(s + " ");
        }

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("\n\nMyStack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        System.out.println("\n\nMyQueue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(40);
        heap.insert(20);
        heap.insert(30);
        heap.insert(10);
        System.out.println("\n\nMyMinHeap:");
        while (!heap.isEmpty()) {
            System.out.print(heap.extractMin() + " ");
        }
    }
}
