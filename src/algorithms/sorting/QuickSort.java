package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void sort(Comparable[] array){
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int left, int right){
        if(left >= right) return;

//        Comparable pivot = array[(left + right) / 2];
        Comparable pivot = pickPivot(array, left, right);
        int index = partition(array, left, right, pivot);
        sort(array, left, index - 1);
        sort(array, index, right);
    }

    private static int partition(Comparable[] array, int left, int right, Comparable pivot){
        while(left <= right) {
            while (array[left].compareTo(pivot) < 0)
                left++;
            while (array[right].compareTo(pivot) > 0)
                right--;

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(Comparable[] array, int left, int right){
        Comparable temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private static Comparable pickPivot(Comparable[] array, int left, int right){
        return pickMedianOfThree(array, left, right);
    }

    private static Comparable pickMedianOfThree(Comparable[] array, int left, int right){
        Comparable first = array[left];
        Comparable middle = array[(left + right) / 2];
        Comparable last = array[right];
        return maxCompare(minCompare(first,middle), minCompare(maxCompare(first,middle),last));
    }

    private static Comparable minCompare(Comparable first, Comparable second){
        return (first.compareTo(second) < 0) ? first:second;
    }

    private static Comparable maxCompare(Comparable first, Comparable second){
        return (first.compareTo(second) > 0) ? first:second;
    }


    public static void main(String[] args) {
        Integer[] testArray = {5,4,1,7,3,2,10,9};
        System.out.println(Arrays.toString(testArray));
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}
