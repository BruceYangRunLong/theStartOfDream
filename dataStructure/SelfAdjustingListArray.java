public class SelfAdjustingListArray<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public SelfAdjustingListArray() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Add an element to the front of the list
    public void insert(T element) {
        //judge if the size is enough
        if (size == array.length) {
            resizeArray();
        }
        // Shift existing elements to make space for the new element
        for (int i = size - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = element;
        size++;
    }

    // Find an element in the list and move it to the front
    public void findAndMoveToFront(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            // Shift the element to the front
            for (int i = index; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = element;
        }
    }

    // Resize the array when it's full
    private void resizeArray() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Print the elements in the list
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelfAdjustingList<Integer> list = new SelfAdjustingList<>();
        
        // Insert elements at the front
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.print("Original List: ");
        list.printList();

        // Find an element and move it to the front
        list.findAndMoveToFront(3);

        System.out.print("List after finding and moving 3 to front: ");
        list.printList();
    }
}
