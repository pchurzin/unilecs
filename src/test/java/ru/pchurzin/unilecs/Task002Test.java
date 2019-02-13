package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task002Test {
    @Test
    public void test() {
        assertEquals(1, Task002.min(new int[]{3, 4, 5, 6, 7, 8, 1, 2}));
        assertEquals(3, Task002.min(new int[]{3}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        Task002.min(new int[]{});
    }
}