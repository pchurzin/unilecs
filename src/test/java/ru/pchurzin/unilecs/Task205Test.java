package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.pchurzin.unilecs.Task205.parseInt;

public class Task205Test {
    @Test
    public void parseIntTest() {
        assertEquals(0, parseInt("jjj"));
        assertEquals(0, parseInt("-jjj"));
        assertEquals(0, parseInt(" +jjj"));
        assertEquals(0, parseInt("   jjj"));
        assertEquals(-5, parseInt("  -5jjj"));
        assertEquals(10, parseInt("  10jjj"));
        assertEquals(10, parseInt("  +10jjj"));
        assertEquals(Integer.MAX_VALUE, parseInt("  +2147483647jjj"));
        assertEquals(Integer.MIN_VALUE, parseInt("  -2147483648jjj"));
        assertEquals(Integer.MAX_VALUE, parseInt("  +2147483648jjj"));
        assertEquals(Integer.MIN_VALUE, parseInt("  -2147483649jjj"));
    }
}