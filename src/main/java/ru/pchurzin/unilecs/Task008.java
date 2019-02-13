package ru.pchurzin.unilecs;

/**
 * https://t.me/unilecs/14
 * Вывести максимальную сумму элементов в массиве
 */

public class Task008 {
    public static int maxSum(int[] array) {
        int maxSum = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
            if (sum < array[i]) {
                sum = array[i];
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
