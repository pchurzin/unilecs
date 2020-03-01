package ru.pchurzin.unilecs;

/**
 * https://telegra.ph/Task-22-Perestanovka-chetnyhnechetnyh-ehlementov-v-massive-10-12
 */
public class Task022 {

    /**
     * Реализация от авторов задачи
     *
     * @param array массив для сортировки
     */
    public static void sortByParityRI(int[] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) { //swap
                array[i] = array[i] ^ array[k];
                array[k] = array[k] ^ array[i];
                array[i] = array[i] ^ array[k];

                k++;
            }
        }
    }

    /**
     * моя реализация
     *
     * @param array массив для сортировки
     */
    public static void sortByParity(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < array.length - 1 && (array[left] & 1) == 0) {
                left++;
            }
            while (right >= 0 && (array[right] & 1) == 1) {
                right--;
            }
            if (left < right) {
                array[left] = array[left] ^ array[right];
                array[right] = array[right] ^ array[left];
                array[left] = array[left] ^ array[right];
            }
        }
    }

    private static int skipOdd(int[] array, int right) {
        while (right >= 0 && (array[right] & 1) == 1) {
            right--;
        }
        return right;
    }

    private static int skipEven(int[] array, int left) {
        while (left < array.length - 1 && (array[left] & 1) == 0) {
            left++;
        }
        return left;
    }
}
