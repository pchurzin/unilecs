package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.pchurzin.unilecs.Task008.maxSum;

public class Task008Test {
    @Test
    public void test() {
        assertEquals(43, maxSum(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7}));
        assertEquals(-1, maxSum(new int[]{-1, -4, -3, -4}));
        assertEquals(12, maxSum(new int[]{-1, 10, -9, 5, 6, -10}));
        assertEquals(5, maxSum(new int[]{1, 3, -8, 3, -1, 2, 1}));
    }
}