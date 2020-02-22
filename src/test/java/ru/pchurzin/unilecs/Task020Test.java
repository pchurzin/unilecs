package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task020Test {

    @Test
    public void pow() {
        assertEquals("", Task020.pow("abs", 0));
        assertEquals("abcabcabc", Task020.pow("abc", 3));
        assertEquals("abc", Task020.pow("abcabcabc", -3));
        assertNull(Task020.pow("abcabc", -3));
    }

    @Test
    public void powA() {
        assertEquals("", Task020.powA("abs", 0));
        assertEquals("abcabcabc", Task020.powA("abc", 3));
        assertEquals("abc", Task020.powA("abcabcabc", -3));
        assertNull(Task020.powA("abcabc", -3));
        assertNull(Task020.powA("abcabcab", -3));
    }
}