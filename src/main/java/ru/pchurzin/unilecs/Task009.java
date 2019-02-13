package ru.pchurzin.unilecs;

/**
 * https://t.me/unilecs/14
 * <p>
 * Напишите программу, которая будет печатать числа Фибоначчи
 * максимально долго (без ошибок времени выполнения)
 */
public class Task009 {
    public static void fib() {
        int n1 = 0;
        int n2 = 1;
        int f = 0;
        while (Integer.MAX_VALUE - f > n1) { //to eliminate overflow
            System.out.println(f);
            n1 = n2;
            n2 = f;
            f = n1 + n2;
        }
        System.out.println(f);
    }
}
