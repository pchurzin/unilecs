package ru.pchurzin.unilecs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static ru.pchurzin.unilecs.Task014.getWordsInReverseOrder;

public class Task014Test {
    @Test
    public void test() {
        assertArrayEquals(new String[]{"third", "second", "first"}, getWordsInReverseOrder("first second third"));
    }

    @Test
    public void testWithIterator() {
        List<String> expected = Arrays.asList("third", "second", "first");
        List<String> actual = new ArrayList<>();
        for (String s : new Task014.WordReverser("first second third".toCharArray())) {
            actual.add(s);
        }
        assertEquals(expected, actual);
    }
}