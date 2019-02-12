package ru.pchurzin.unilecs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://t.me/unilecs/10
 * можно ли сделать строку палиндромом
 */
public class Task005 {
    public static void main(String[] args) {
        System.out.println(canBePalindrome("bbo"));//true
        System.out.println(canBePalindrome("bob"));//true
        System.out.println(canBePalindrome("cat"));//false
    }

    private static boolean canBePalindrome(String s) {
        Objects.requireNonNull(s);
        if (s.length() < 3) {
            return true;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.merge(c, 1, Integer::sum);
        }
        boolean hasOddCount = false;
        for (int i : charCount.values()) {
            if (i % 2 != 0) {
                if (hasOddCount) return false;
                hasOddCount = true;
            }
        }
        return true;
    }
}
