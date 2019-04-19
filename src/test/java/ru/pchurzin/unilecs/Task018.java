package ru.pchurzin.unilecs;

/**
 * https://telegra.ph/Task-18-Vyvesti-neparnyj-ehlement-v-chislovom-massive-10-07
 * <p>
 * Вывести непарный элемент в числовом массиве
 */

public class Task018 {
    static int getNonPairedElement(int[] array) {
        int result = 0;
        for (int i : array) {
            result ^= i;
        }
        return result;
    }
}
