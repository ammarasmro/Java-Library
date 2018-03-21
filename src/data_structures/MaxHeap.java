package data_structures;

import java.util.Arrays;

public class MaxHeap<T extends  Comparable<T>> {
    private T[] array;
    private int size;
    private int capacity;
    private int DEFAULT_SIZE = 10;

    MaxHeap(){
        array = (T[]) new Comparable[DEFAULT_SIZE];

        capacity = 10;
        size = 0;
    }


    private void heapifyDown(){
        int currentIndex = 0;
        while(hasLeftChild(currentIndex)){
            int maxChildIndex = getLeftChildIndex(currentIndex);
            if(hasRightChild(currentIndex) && array[maxChildIndex].compareTo(getRightChild(currentIndex)) < 0)
                maxChildIndex = getRightChildIndex(currentIndex);

            if(array[currentIndex].compareTo(array[maxChildIndex]) < 0) {
                swap(currentIndex, maxChildIndex);
                currentIndex = maxChildIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyUp(){
        int currentIndex = size - 1;
        while(hasParent(currentIndex) && array[currentIndex].compareTo(getParent(currentIndex)) > 0){
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    private void swap(int firstIndex, int secondIndex){
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private int getParentIndex(int index){ return (index - 1)/2; }
    private int getLeftChildIndex(int index){ return index * 2 + 1; }
    private int getRightChildIndex(int index){ return index * 2 + 2; }

    private boolean hasParent(int index){ return getParentIndex(index) >= 0; }
    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) <= size; }
    private boolean hasRightChild(int index){ return getRightChildIndex(index) <= size; }

    private T getParent(int index){ return array[getParentIndex(index)]; }
    private T getLeftChild(int index){ return array[getLeftChildIndex(index)]; }
    private T getRightChild(int index){ return array[getRightChildIndex(index)]; }


    public T peekRoot(){
        if(size == 0) return null;
        return array[0];
    }
    public T popRoot(){
        if(size == 0) return null;
        T root = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown();
        return root;
    }
    public void appendChild(T element){
        ensureCapacity();
        array[size] = element;
        size++;
        heapifyUp();
    }
    private void ensureCapacity(){
        if(size + 1 >= capacity){
            array = Arrays.copyOf(array, array.length * 2);
            capacity = array.length;
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }


    public static void main(String[] args) {
        MaxHeap<Integer> maxIntsHeap = new MaxHeap<Integer>();
        MaxHeap<String> maxStrsHeap = new MaxHeap<String>();
        int[] testInts = new int[]{2,3,6,7,8,4,43,5,1,0,34,212,1,2,3,4};
        String[] testStrings = new String[]{"B","C","Z","Y","A"};
        for(int number: testInts){
            maxIntsHeap.appendChild(number);
        }
        System.out.println(maxIntsHeap);
        while(maxIntsHeap.peekRoot() != null){
            System.out.println(maxIntsHeap.popRoot());
        }

        for(String str: testStrings){
            maxStrsHeap.appendChild(str);
        }
        System.out.println(maxStrsHeap);
        while(maxStrsHeap.peekRoot() != null){
            System.out.println(maxStrsHeap.popRoot());
        }

        System.out.println("Done!");
    }
}
