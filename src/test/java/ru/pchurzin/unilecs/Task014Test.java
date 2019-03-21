package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.pchurzin.unilecs.Task014.getWordsInReverseOrder;

public class Task014Test {
    @Test
    public void test() {
        assertArrayEquals(new String[]{"third", "second", "first"}, getWordsInReverseOrder("first second third"));
    }
}