package ru.pchurzin.unilecs;

import java.util.*;

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
        return new AdvancedAtm(storage, amount).getResult();
    }

    private static class AdvancedAtm {
        private List<Integer> banknotes = new ArrayList<>();
        private Map<Integer, Integer> result = new HashMap<>();

        public AdvancedAtm(Map<Integer, Integer> storage, int amount) {
            for (Map.Entry<Integer, Integer> entry : storage.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    banknotes.add(entry.getKey());
                }
            }
            Collections.sort(banknotes);
            List<Integer> bnList = getBanknotes(this.banknotes.size() - 1, amount);
            bnList.forEach(i -> result.merge(i, 1, Integer::sum));
        }

        public Map<Integer, Integer> getResult() {
            return result;
        }

        private List<Integer> getBanknotes(int index, int remaining) {
            List<Integer> result = new ArrayList<>();
            if (remaining < 0) {
                return result;
            }
            if (index == 0) {
                if (banknotes.get(index) == remaining) {
                    result.add(banknotes.get(index));
                }
                return result;
            }

            List<Integer> with = getBanknotes(index - 1, remaining - banknotes.get(index));
            List<Integer> without = getBanknotes(index - 1, remaining);

            if (!with.isEmpty()) {
                result.addAll(with);
                result.add(banknotes.get(index));
            } else if (!without.isEmpty()) {
                result.addAll(without);
            }
            return result;
        }
    }
}
