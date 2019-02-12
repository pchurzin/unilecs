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
    public static void main(String[] args) {
        System.out.println(doesArrayContainsDividers(new int[]{-1, 0, 0, 3, 3, 10}, -10)); // true
        System.out.println(doesArrayContainsDividers(new int[]{0, 3, 3, 10}, 3));          // false
        System.out.println(doesArrayContainsDividers(new int[]{1, 0, 3, 3, 9, 15}, 10));   // false
        System.out.println(doesArrayContainsDividers(new int[]{1, 0, 3, 3, 20, 8}, 10));   // false
        System.out.println(doesArrayContainsDividers(new int[]{1, 0, 3, 3, 20, 8}, 0));    // true
        System.out.println(doesArrayContainsDividers(new int[]{1, 0, -3, 3, -10}, -9));    // true
        System.out.println(doesArrayContainsDividers(new int[]{}, -9));    // false
        System.out.println(doesArrayContainsDividers(new int[]{9}, -9));    // false
    }

    static boolean doesArrayContainsDividers(int[] array, int x) {
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
