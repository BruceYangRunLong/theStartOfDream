public class SelfAdjustingList<T> {
    private Node<T> head;
    
    // Node class to represent elements in the list
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public SelfAdjustingList() {
        head = null;
    }

    // Inserts an element at the front of the list
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // Finds an element in the list and moves it to the front
    public void findAndMoveToFront(T data) {
        if (head == null) {
            return; // List is empty
        }

        // If the element is already at the front, no need to move it
        if (head.data.equals(data)) {
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        // If the element is found, move it to the front
        if (current != null) {
            prev.next = current.next;
            current.next = head;
            head = current;
        }
    }

    // Print the elements of the list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelfAdjustingList<Integer> list = new SelfAdjustingList<>();

        list.insert(1);
        list.insert(2);
        list.insert(3);

        System.out.print("Initial list: ");
        list.printList();

        int elementToFind = 2;
        list.findAndMoveToFront(elementToFind);

        System.out.print("List after finding " + elementToFind + ": ");
        list.printList();
    }
}
