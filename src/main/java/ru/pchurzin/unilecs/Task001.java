package ru.pchurzin.unilecs;

import java.util.HashMap;
import java.util.Map;

/**
 * Все ли символы в строке встречаются только один раз
 * https://t.me/unilecs/4
 */

public class Task001 {

    public static void main(String[] args) {
        System.out.println(checkUniq("abcdea"));
        System.out.println(checkUniq("abcde"));
    }

    private static boolean checkUniq(String str) {
        Map<Character, Integer> charCounter = new HashMap<>();
        for (Character c : str.toCharArray()) {
            Integer count = charCounter.merge(c, 1, (old, val) -> old + 1);
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
