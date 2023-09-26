class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node header;
    private int size;

    public LinkedList() {
        header = new Node(-1); // Initialize with a dummy header node
        size = 0;
    }

    // a. Return the size of the linked list
    public int getSize() {
        return size;
    }

    // b. Print the linked list
    public void printList() {
        Node current = header.next;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // c. Test if a value x is contained in the linked list
    public boolean contains(int x) {
        Node current = header.next;
        while (current != null) {
            if (current.data == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // d. Add a value x if it is not already contained in the linked list
    public void add(int x) {
        if (!contains(x)) {
            Node newNode = new Node(x);
            newNode.next = header.next;
            header.next = newNode;
            size++;
        }
    }

    // e. Remove a value x if it is contained in the linked list
    public void remove(int x) {
        Node current = header;
        while (current.next != null) {
            if (current.next.data == x) {
                current.next = current.next.next;
                size--;
                return; // Value found and removed
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println("Size of the linked list: " + linkedList.getSize());
        System.out.print("Linked list elements: ");
        linkedList.printList();

        int valueToSearch = 2;
        System.out.println("Contains " + valueToSearch + ": " + linkedList.contains(valueToSearch));

        int valueToRemove = 2;
        linkedList.remove(valueToRemove);
        System.out.print("Linked list after removing " + valueToRemove + ": ");
        linkedList.printList();
    }
}
