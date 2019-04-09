package ru.pchurzin.unilecs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Task016Test {
    static final int AMOUNT_NO_MONEY = 19890;
    static final int AMOUNT_MONEY = 19250;
    static final int AMOUNT_UNUSUAL = 120;
    static final Map<Integer, Integer> storage = new HashMap<>();

    static {
        storage.put(50, 10);
        storage.put(100, 0);
        storage.put(500, 10);
        storage.put(1000, 10);
        storage.put(5000, 2);
        storage.put(30, 10);
    }

    @Test
    public void getMoney() {
        Map<Integer, Integer> money = Task016.getMoney(AMOUNT_NO_MONEY, 500, 1000, 50, 100, 5000);
        System.out.println("Queried amount = " + AMOUNT_NO_MONEY);
        printResult(money);
        Assert.assertEquals(0, money.size());

        money = Task016.getMoney(AMOUNT_MONEY, 50, 100, 500, 1000, 5000);
        System.out.println("Queried amount = " + AMOUNT_MONEY);
        printResult(money);
        Assert.assertTrue(money.size() > 0);

        /*money = Task016.getMoney(AMOUNT_UNUSUAL, 50, 30, 100, 500, 1000, 5000);
        System.out.println("Queried amount = " + AMOUNT_UNUSUAL);
        printResult(money);
        Assert.assertTrue(money.size() > 0);*/
    }

    @Test
    public void getMoneyWithStorage() {
        Map<Integer, Integer> money = Task016.getMoney(AMOUNT_NO_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_NO_MONEY);
        printResult(money);
        Assert.assertEquals(0, money.size());

        money = Task016.getMoney(AMOUNT_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_MONEY);
        printResult(money);
        Assert.assertTrue(money.size() > 0);

        /*money = Task016.getMoney(AMOUNT_UNUSUAL, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_UNUSUAL);
        printResult(money);
        Assert.assertTrue(money.size() > 0);*/
    }

    @Test
    public void getMoneyAdvanced() {
        Map<Integer, Integer> money = Task016.getMoneyAdvanced(AMOUNT_UNUSUAL, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_UNUSUAL);
        printResult(money);
        Assert.assertTrue(money.size() > 0);

        money = Task016.getMoneyAdvanced(AMOUNT_NO_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_NO_MONEY);
        printResult(money);
        Assert.assertEquals(0, money.size());

        money = Task016.getMoneyAdvanced(AMOUNT_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_MONEY);
        printResult(money);
        Assert.assertTrue(money.size() > 0);
    }

    private void printResult(Map<Integer, Integer> result) {
        if (result.isEmpty()) {
            System.out.println("Can't give money");
            return;
        }
        result.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(key -> System.out.println(key + "x" + result.get(key)));
    }
}