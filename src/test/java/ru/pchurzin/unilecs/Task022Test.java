package ru.pchurzin.unilecs;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Task022Test {

    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    @Test
    public void myImplementation() {
        int[] ints = IntStream.generate(threadLocalRandom::nextInt).limit(10_000).toArray();
        Task022.sortByParity(ints);
        int parityBorder = getParityBorder(ints);
        for (int i = 0; i < parityBorder; i++) {
            Assert.assertTrue("odd " + ints[i] + " at ints[" + i + "]", (ints[i] & 1) == 0);
        }
        for (int i = parityBorder; i < ints.length; i++) {
            Assert.assertTrue("even " + ints[i] + " at ints[" + i + "]", (ints[i] & 1) == 1);
        }
    }

    @Test
    public void referenceImplementation() {
        int[] ints = IntStream.generate(threadLocalRandom::nextInt).limit(10_000).toArray();
        Task022.sortByParity(ints);
        int parityBorder = getParityBorder(ints);
        for (int i = 0; i < parityBorder; i++) {
            Assert.assertTrue("odd " + ints[i] + " at ints[" + i + "]", (ints[i] & 1) == 0);
        }
        for (int i = parityBorder; i < ints.length; i++) {
            Assert.assertTrue("even " + ints[i] + " at ints[" + i + "]", (ints[i] & 1) == 1);
        }
    }

    @Test
    public void sortByParity() {
        int[] ints = new int[]{1, 0, 3, 4, 0, 6, 7, 8, 9, 10};
        Task022.sortByParity(ints);
        int parityBorder = getParityBorder(ints);
        for (int i = 0; i < parityBorder; i++) {
            Assert.assertTrue((ints[i] & 1) == 0);
        }
        for (int i = parityBorder; i < ints.length; i++) {
            Assert.assertTrue((ints[i] & 1) == 1);
        }
    }

    private int getParityBorder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                return i;
            }
        }
        return array.length - 1;
    }

}