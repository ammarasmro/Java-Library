package data_structures;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * @param <T>
 */
public class LinkedQueue<T> {

    // Start the stack with a null head and tail
    private Node head = null;
    private Node tail = null;
    private int size;

    /**
     * Instialize queue with size 0
     */
    public LinkedQueue(){
        this.size = 0;
    }

    /**
     * enqueue an item by assigning it as the new tail and the next of the previous tail to the new one
     * @param item
     */
    public void enqueue(T item){
        Node oldTail = tail;
        tail = new Node<T>();
        tail.item = item;
        tail.next = null;
        if(isEmpty()) head = tail;
        else          oldTail.next = tail;
        size++;
    }

    /**
     * Assign head to the next object and return the current head
     * TODO: check if queue is empty
     * @return
     */
    public T dequeue(){
        Node<T> currentHead = head;
        head = head.next;
        if(isEmpty()) tail = null;
        size--;
        return currentHead.item;
    }

    /**
     * Check if queue is empty by checking if head is null
     * @return
     */
    public boolean isEmpty(){
        return head == null;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }

    /**
     * Inner class to represent an object
     * @param <T>
     */
    private class Node<T> {
        T item;
        Node<T> next;
    }
}
