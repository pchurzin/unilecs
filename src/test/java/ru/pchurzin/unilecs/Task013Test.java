package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.pchurzin.unilecs.Task013.compress;

public class Task013Test {
    @Test
    public void test() {
        assertEquals("Z3A1B2E3", compress("ZZZABBEEE"));
        assertEquals("abcca", compress("abcca"));
    }
}