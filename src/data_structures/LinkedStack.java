package data_structures;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * @param <T>
 */
public class LinkedStack<T> {

    // Start the stack with a null head
    private Node head = null;
    private int size;

    /**
     * Instialize stack with size 0
     */
    public LinkedStack(){
        this.size = 0;
    }

    /**
     * push an item into the stack by assigning it as the head and its next is the previous head
     * @param item
     */
    public void push(T item){
        Node currentHead = head;
        head = new Node<T>();
        head.item = item;
        head.next = currentHead;
        size++;
    }

    /**
     * Assign head to the next object and return the current head
     * TODO: check if stack is empty
     * @return
     */
    public T pop(){
        Node<T> currentHead = head;
        head = head.next;
        size--;
        return currentHead.item;
    }

    /**
     * Check if stack is empty by checking if head is null
     * @return
     */
    public boolean isEmpty(){
        return head == null;
    }


    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("first");
        stack.push("second");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
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
