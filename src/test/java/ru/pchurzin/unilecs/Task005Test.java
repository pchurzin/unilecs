package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pchurzin.unilecs.Task005.canBePalindrome;

public class Task005Test {
    @Test
    public void test() {
        assertTrue(canBePalindrome("bbo"));//true
        assertTrue(canBePalindrome("bob"));//true
        assertFalse(canBePalindrome("cat"));//false
    }
}