package ru.pchurzin.unilecs;

/**
 * https://t.me/unilecs/14
 * Вывести максимальную сумму элементов в массиве
 */

public class Task008 {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7}));
        System.out.println(maxSum(new int[]{-1, -4, -3, -4}));
        System.out.println(maxSum(new int[]{-1, 10, -9, 5, 6, -10}));
        System.out.println(maxSum(new int[]{1, 3, -8, 3, -1, 2, 1}));

    }

    private static int maxSum(int[] array) {
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
