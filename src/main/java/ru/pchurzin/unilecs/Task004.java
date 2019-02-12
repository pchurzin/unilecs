package ru.pchurzin.unilecs;

/**
 * Вывести индекс заданного элемента в отсортированном по возрастанию и циклически сдвинутом массиве
 * https://t.me/unilecs/8
 */
public class Task004 {
    public static void main(String[] args) {
        System.out.println(getIndexOfInputElementInSortedArray(new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 7));
        System.out.println(getIndexOfInputElementInSortedArray(new int[]{3, 4, 5, 6, 7}, 8));
        System.out.println(getIndexOfInputElementInSortedArray(new int[]{8, 3, 4, 5, 6, 7}, 5));
        System.out.println(getIndexOfInputElementInSortedArray(new int[]{}, 1));
        System.out.println(getIndexOfInputElementInSortedArray(new int[]{3}, 1));
        System.out.println(getIndexOfInputElementInSortedArray(new int[]{3}, 3));
    }

    private static int getIndexOfInputElementInSortedArray(int[] array, int element) {
        if (array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while (end - start > 1) {
            int middle = (start + end) / 2;
            if (array[start] <= array[middle]) {//first half of the array is sorted
                if (array[start] <= element && element <= array[middle]) {//the element is in the first half of the array
                    end = middle;
                } else {//the element is in the second half of the array
                    start = middle;
                }
            } else { // the second half of the array is sorted
                if (array[middle] <= element && element <= array[end]) {//the element is in the second half
                    start = middle;
                } else {//the element is in the first half of the array
                    end = middle;
                }
            }

        }
        return array[start] == element ? start : array[end] == element ? end : -1;
    }
}
