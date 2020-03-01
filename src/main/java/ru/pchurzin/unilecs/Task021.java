package ru.pchurzin.unilecs;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://telegra.ph/Task-21-1-Poisk-dvuh-otsutstvuyushchih-ehlementa-v-massive-10-12
 */
public class Task021 {

    public static String findPair(int[] array) {
        int n = array.length;
        int fullSum = IntStream.rangeClosed(1, n).sum();
        int actualSum = Arrays.stream(array).sum();
        int sum = fullSum - actualSum;

        int fullProduct = IntStream.rangeClosed(1, n)
                .reduce((left, right) -> left * right)
                .orElseThrow(RuntimeException::new);
        int actualProduct = Arrays.stream(array)
                .filter(value -> value != 0)
                .reduce((left, right) -> left * right)
                .orElseThrow(RuntimeException::new);

        int product = fullProduct / actualProduct;

        int discriminant = sum * sum - 4 * product;
        int x;
        if (discriminant >= 0) {
            x = (int) (sum + Math.sqrt(discriminant)) / 2;
        } else {
            throw new AssertionError("It's a miracle");
        }
        int y = sum - x;
        return y > x ? x + "," + y : y + "," + x;
    }
}
