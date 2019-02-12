package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task001Test {
    @Test
    public void test() {
        assertFalse(Task001.checkUniq("abcdea"));
        assertTrue(Task001.checkUniq("abcde"));
    }
}