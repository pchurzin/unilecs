package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task003Test {
    @Test
    public void test() {
        char[] result = Task003.replaceSpaceBySpecialSymbols("Mr John Smith".toCharArray());
        assertEquals("Mr%20John%20Smith", String.valueOf(result));
        result = Task003.replaceSpaceBySpecialSymbols(" gg ".toCharArray());
        assertEquals("%20gg%20", String.valueOf(result));
    }
}