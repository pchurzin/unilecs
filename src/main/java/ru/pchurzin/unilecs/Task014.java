package ru.pchurzin.unilecs;

import java.util.Arrays;

/**
 * https://t.me/unilecs/28
 *
 * Вывести слова в строке в обратном порядке
 */

public class Task014 {
    static String[] getWordsInReverseOrder(String input) {
        String[] s = input.split(" ");
        String[] result = new String[s.length];
        for (int i = s.length - 1; i >= 0; i--) {
            result[s.length - i - 1] = s[i];
        }
        return result;
    }
}
