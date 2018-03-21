package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(Comparable[] array){
        sort(array, new Comparable[array.length], 0, array.length - 1);

    }

    public static void sort(Comparable[] array, Comparable[] temp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd) return;
        int middle = (leftStart + rightEnd) / 2;
        sort(array, temp, leftStart, middle);
        sort(array, temp, middle + 1, rightEnd);
        merge(array, temp, leftStart, rightEnd);
    }

    public static void merge(Comparable[] array, Comparable[] temp, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(array[left].compareTo(array[right]) <= 0){
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

    public static void main(String[] args) {
        Integer[] testArray = {5,4,1,7,3,2,10,9};
        System.out.println(Arrays.toString(testArray));
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}
