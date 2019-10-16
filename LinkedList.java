public class LinkedList<T> implements List<T> {

    Node head = null;
    int size;

    private class Node<T> {
        private T data;
        private Node next;

        public Node(T item){
            data = item;
            next = null;
        }

    }

    @Override
    public void add(T item) {
        if (head == null){
            head = new Node(item);
            size++;
        } else {
            Node prev = head;
            while (prev.next != null)
                prev = prev.next;
            Node curr = new Node(item);
            prev.next = curr;
            size++;
        }
    }

    @Override
    public void add(int pos, T item) {
        if (pos < 0 || pos > size)
            throw new RuntimeException();

        if (pos == 0){
            Node curr = new Node(item);
            curr.next = head;
            head = curr;
            size++;
        } else {
            Node current = new Node(item);
            Node prev = head;
            for (int i = 0; i< pos-1; i++) {
                prev = prev.next;
            }
            current.next = prev.next;
            prev.next = current;
            size++;
        }
    }

    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= size)
            throw new RuntimeException();
        Node prev = head;
        for (int i = 0; i < pos; i++) {
            prev = prev.next;
        }
        return (T)prev.data;
    }

    @Override
    public T remove(int pos) {
        if (pos < 0 || pos >= size)
            throw new RuntimeException();

        if (pos == 0){
            T item = (T) head.data;
            head = head.next;
            size--;
            return item;
        } else {
            Node prev = head;
            for (int i = 0; i < pos-1; i++){
                prev = prev.next;
            }
            Node curr = prev.next;
            T item = (T) curr.data;
            prev.next = curr.next;
            size--;
            return item;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
