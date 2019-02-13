package ru.pchurzin.unilecs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://t.me/unilecs/20
 * <p>
 * Есть ли такие числа в массиве, перемножив которые получим Х
 */

public class Task012 {
    public static boolean doesArrayContainsDividers(int[] array, int x) {
        Map<Integer, Integer> counter = new HashMap<>();
        Arrays.stream(array)
                .filter(i -> i == 0 ? x == 0 : (x / i) != 0 && (x % i) == 0)
                .forEach(value -> counter.merge(value, 1, Integer::sum));

        return counter.keySet().stream().anyMatch(i -> {
            if (i == 0) {
                return x == 0;
            }
            int anotherDivider = x / i;
            return anotherDivider == i ?
                    counter.get(anotherDivider) > 1 :
                    counter.containsKey(anotherDivider);
        });
    }
}
