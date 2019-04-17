package ru.pchurzin.unilecs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Task016Test {
    static final int AMOUNT_MONEY = 19890;
    static final int AMOUNT_NO_MONEY = 19895;
    static final int AMOUNT_SIMPLE_MONEY = 19250;
    static final int AMOUNT_UNUSUAL = 120;
    static final Map<Integer, Integer> storage = new HashMap<>();

    static {
        storage.put(50, 10);
        storage.put(100, 10);
        storage.put(500, 10);
        storage.put(1000, 10);
        storage.put(5000, 10);
        storage.put(30, 10);
    }

    @Test
    public void getMoney() {
        Map<Integer, Integer> money = Task016.getMoney(AMOUNT_SIMPLE_MONEY, 500, 1000, 50, 100, 5000, 30);
        System.out.println("Queried amount = " + AMOUNT_SIMPLE_MONEY);
        printResult(money);
        Assert.assertEquals(AMOUNT_SIMPLE_MONEY, getSum(money));

        money = Task016.getMoney(AMOUNT_NO_MONEY, 500, 1000, 50, 100, 5000, 30);
        System.out.println("Queried amount = " + AMOUNT_NO_MONEY);
        printResult(money);
        Assert.assertEquals(0, getSum(money));

        money = Task016.getMoney(AMOUNT_SIMPLE_MONEY, 50, 100, 500, 1000, 5000, 30);
        System.out.println("Queried amount = " + AMOUNT_SIMPLE_MONEY);
        printResult(money);
        Assert.assertEquals(AMOUNT_SIMPLE_MONEY, getSum(money));
    }

    @Test
    public void cantGiveMoneyWithSimpleSolution() {
        System.out.println("This test case demonstrates that simple solution can't give money in some cases.");
        Map<Integer, Integer> money = Task016.getMoney(AMOUNT_MONEY, 50, 100, 500, 1000, 5000, 30);
        System.out.println("Queried amount = " + AMOUNT_MONEY);
        printResult(money);
//        Assert.assertEquals(AMOUNT_MONEY, getSum(money));

        money = Task016.getMoney(AMOUNT_UNUSUAL, 50, 30, 100, 500, 1000, 5000);
        System.out.println("Queried amount = " + AMOUNT_UNUSUAL);
        printResult(money);
//        Assert.assertEquals(AMOUNT_UNUSUAL, getSum(money));

        money = Task016.getMoney(AMOUNT_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_MONEY);
        printResult(money);
//        Assert.assertEquals(AMOUNT_MONEY, getSum(money));

        money = Task016.getMoney(AMOUNT_UNUSUAL, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_UNUSUAL);
        printResult(money);
//        Assert.assertEquals(AMOUNT_UNUSUAL, getSum(money));

    }

    @Test
    public void getMoneyWithStorage() {
        Map<Integer, Integer> money = Task016.getMoney(AMOUNT_NO_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_NO_MONEY);
        printResult(money);
        Assert.assertEquals(0, getSum(money));

        money = Task016.getMoney(AMOUNT_SIMPLE_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_SIMPLE_MONEY);
        printResult(money);
        Assert.assertEquals(AMOUNT_SIMPLE_MONEY, getSum(money));
    }

    @Test
    public void getMoneyAdvanced() {
        Map<Integer, Integer> money = Task016.getMoneyAdvanced(AMOUNT_UNUSUAL, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_UNUSUAL);
        printResult(money);
        Assert.assertEquals(AMOUNT_UNUSUAL, getSum(money));

        money = Task016.getMoneyAdvanced(AMOUNT_NO_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_NO_MONEY);
        printResult(money);
        Assert.assertEquals(0, getSum(money));

        money = Task016.getMoneyAdvanced(AMOUNT_SIMPLE_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_SIMPLE_MONEY);
        printResult(money);
        Assert.assertEquals(AMOUNT_SIMPLE_MONEY, getSum(money));

        money = Task016.getMoneyAdvanced(AMOUNT_MONEY, new HashMap<>(storage));
        System.out.println("Queried amount = " + AMOUNT_MONEY);
        printResult(money);
        Assert.assertEquals(AMOUNT_MONEY, getSum(money));
    }

    private int getSum(Map<Integer, Integer> money) {
        return money.entrySet().stream()
                .map(entry -> entry.getKey() * entry.getValue())
                .reduce(Integer::sum).orElse(0);
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