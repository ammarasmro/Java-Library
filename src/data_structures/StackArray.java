package data_structures;

import java.util.Arrays;

/**
 * Stack implementation using a dynamic array.
 *
 * Push time: O(1) Amortized!
 * Pop time: O(1) Amortized!
 * Less time and space than linked list implementation
 */
public class StackArray {

    // Stack array
    private String[] stack;
    // Current pointer
    private int n;

    /**
     * Initialize an array of ten items
     */
    public StackArray(){
        stack = new String[10];
    }

    /**
     * Check if array is almost full then double the capacity
     * @param item
     */
    public void push(String item){
        if(n >= stack.length - 2) resize(stack.length * 2);
        stack[n++] = item;
    }

    /**
     * take the last element out. Then shrink the array if one 25% is full
     * @return
     */
    public String pop(){
        String item = stack[--n];
        if(n <= stack.length/4) resize(stack.length / 2);
        stack[n] = null;
        return item;
    }

    /**
     * Copy array to new capacity
     * @param capacity
     */
    private void resize(int capacity){
        this.stack = Arrays.copyOf(stack, capacity);
    }

    /**
     * Check if array is empty
      * @return
     */
    public boolean isEmpty(){
        return n == 0;
    }

    /**
     *
     * @return pointer to the last element, aka, size
     */
    public int size(){ return n; }

    public static void main(String[] args) {
        StackArray test = new StackArray();
        test.push("first");
        test.push("second");
        System.out.println(test.pop());
        System.out.println(test.pop());
        int i = 0;
        while (i < 20){
            test.push("first");
            test.push("second");
            i++;
        }
    }
}
