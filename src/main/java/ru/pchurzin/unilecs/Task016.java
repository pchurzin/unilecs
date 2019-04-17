package ru.pchurzin.unilecs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://telegra.ph/Task-16-Kak-rabotaet-bankomat-10-05
 * <p>
 * Как работает банкомат
 */

public class Task016 {
    static Map<Integer, Integer> getMoney(int amount, int... values) {
        Map<Integer, Integer> result = new HashMap<>();
        Arrays.sort(values);
        int remain = amount;
        for (int i = values.length - 1; i >= 0 && remain >= values[0]; i--) {
            int count = remain / values[i];
            if (count == 0) {
                continue;
            }
            result.put(values[i], count);
            remain -= count * values[i];
        }
        if (remain != 0) {
            return Collections.emptyMap();
        }
        return result;
    }

    static Map<Integer, Integer> getMoney(int amount, Map<Integer, Integer> storage) {
        Map<Integer, Integer> result = new HashMap<>();
        Integer[] values = new Integer[0];
        values = storage.keySet().toArray(values);
        Arrays.sort(values);
        int remain = amount;
        for (int i = values.length - 1; i >= 0 && remain >= values[0]; i--) {
            int count = remain / values[i];
            count = Math.min(count, storage.get(values[i]));
            if (count == 0) {
                continue;
            }
            result.put(values[i], count);
            remain -= count * values[i];
            storage.put(values[i], storage.get(values[i]) - count);
        }
        if (remain != 0) {
            return Collections.emptyMap();
        }
        return result;
    }

    static Map<Integer, Integer> getMoneyAdvanced(int amount, Map<Integer, Integer> storage) {
        List<Integer> coinValuesCandidates = storage.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .filter(value -> value <= amount)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        //an array to store minimum of banknotes needed to get the sum
        //i.e. minCoins[10] - minimum number of banknotes to get the sum of 10.
        //if this is impossible then it holds Integer.MAX_VALUE
        Map<Integer, Integer> result = new HashMap<>();
        int[] minCoins = new int[amount + 1];
        minCoins[0] = 0;
        for (int sum = 1; sum <= amount; sum++) {
            minCoins[sum] = Integer.MAX_VALUE;
            for (int coin : coinValuesCandidates) {
                if (sum >= coin && minCoins[sum] - minCoins[sum - coin] > 1) {//minCoins[sum] > minCoins[sum - coin] + 1
                    minCoins[sum] = minCoins[sum - coin] + 1;
                }
            }
        }

        if (minCoins[amount] == Integer.MAX_VALUE) {
            return Collections.EMPTY_MAP;
        }

        int remain = amount;
        while (remain > 0) {
            int curRemain = remain;
            for (int coin : coinValuesCandidates) {
                if (storage.get(coin) <= 0) {
                    continue;
                }
                if (remain >= coin && minCoins[remain] == minCoins[remain - coin] + 1) {
                    result.merge(coin, 1, (old, value) -> old + value);
                    storage.compute(coin,(key, oldValue) -> --oldValue);
                    remain -= coin;
                    break;
                }
            }

            if (curRemain == remain) {
                return Collections.EMPTY_MAP;
            }
        }

        return result;
    }
}
