public class TestMyArrayList {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        System.out.println("=== ADD ===");
        list.add(5);
        list.add(3);
        list.add(9);
        list.addFirst(1);
        list.addLast(7);

        printList(list);

        System.out.println("=== GET ===");
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Index 2: " + list.get(2));

        System.out.println("=== REMOVE ===");
        list.remove(2); // remove index 2
        printList(list);

        System.out.println("=== SET ===");
        list.set(1, 100);
        printList(list);

        System.out.println("=== SORT ===");
        list.sort();
        printList(list);

        System.out.println("=== INFO ===");
        System.out.println("Index of 7: " + list.indexOf(7));
        System.out.println("Last index of 100: " + list.lastIndexOf(100));
        System.out.println("Exists 9? " + list.exists(9));
        System.out.println("Size: " + list.size());

        System.out.println("=== CLEAR ===");
        list.clear();
        printList(list);
    }

    public static void printList(MyList<?> list) {
        System.out.print("List: ");
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }
}
