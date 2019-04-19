package ru.pchurzin.unilecs;

/**
 * https://t.me/unilecs/35
 * <p>
 * Поменять значения переменных местами не используя третью
 */

public class Task017 {
    static void swap() {
        int a = 556;
        int b = 876;
        a = a + b;
        b = a - b;
        a = a - b;
    }

    static void swap2() {
        int a = 556;
        int b = 876;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
    }
}
