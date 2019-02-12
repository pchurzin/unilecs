package ru.pchurzin.unilecs;

/**
 * Найти минимальный элемент в отсортированном по возрастанию и циклически сдвинутом массиве
 * https://t.me/unilecs/6
 */
public class Task002 {
    public static void main(String[] args) {
        System.out.println(min(new int[]{3, 4, 5, 6, 7, 8, 1, 2}));
        try {
            System.out.println(min(new int[]{}));
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        System.out.println(min(new int[]{3}));
    }

    private static int min(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array must not be empty");
        }

        int start = 0;
        int end = array.length - 1;
        if (array.length == 1 || array[start] <= array[end]) {
            return array[start];
        }

        while (end - start > 1) {
            int middle = (start + end) / 2;

            if (array[start] > array[middle]) {
                end = middle;
            }

            if (array[middle] > array[end]) {
                start = middle;
            }
        }
        return array[start] < array[end] ? array[start] : array[end];
    }
}
