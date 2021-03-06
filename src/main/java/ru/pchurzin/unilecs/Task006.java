package ru.pchurzin.unilecs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://t.me/unilecs/12
 * проверить является ли одна строка перестановкой другой
 */

public class Task006 {
    public static boolean isPermutation(String s1, String s2) {
        Objects.requireNonNull(s1);
        Objects.requireNonNull(s2);

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> charCounter1 = new HashMap<>();
        Map<Character, Integer> charCounter2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            charCounter1.merge(c, 1, Integer::sum);
        }
        for (char c : s2.toCharArray()) {
            charCounter2.merge(c, 1, Integer::sum);
        }

        return charCounter1.equals(charCounter2);
    }

    public static boolean isPermutation2(String s1, String s2) {
        Objects.requireNonNull(s1);
        Objects.requireNonNull(s2);

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}
