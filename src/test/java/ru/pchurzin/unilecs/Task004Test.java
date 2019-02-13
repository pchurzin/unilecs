package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.pchurzin.unilecs.Task004.getIndexOfInputElementInSortedArray;

public class Task004Test {
    @Test
    public void test() {
        assertEquals(4, getIndexOfInputElementInSortedArray(new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 7));
        assertEquals(-1, getIndexOfInputElementInSortedArray(new int[]{3, 4, 5, 6, 7}, 8));
        assertEquals(3, getIndexOfInputElementInSortedArray(new int[]{8, 3, 4, 5, 6, 7}, 5));
        assertEquals(-1, getIndexOfInputElementInSortedArray(new int[]{}, 1));
        assertEquals(-1, getIndexOfInputElementInSortedArray(new int[]{3}, 1));
        assertEquals(0, getIndexOfInputElementInSortedArray(new int[]{3}, 3));
    }
}