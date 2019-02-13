package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static ru.pchurzin.unilecs.Task010.changeMatrix;

public class Task010Test {
    @Test
    public void test() {
        int[][] input = {
                {-1, 2, 4, 0, 7},
                {0, -2, 2, 5, 7},
                {1, 1, 1, 1, -9},
                {1, 3, -3, 0, 7},
        };
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, -9},
                {0, 0, 0, 0, 0},
        };

        changeMatrix(input);

        for (int i = 0; i < input.length; i++) {
            assertArrayEquals(expected[i], input[i]);
        }
    }
}