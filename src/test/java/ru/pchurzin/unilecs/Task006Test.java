package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pchurzin.unilecs.Task006.isPermutation;
import static ru.pchurzin.unilecs.Task006.isPermutation2;

public class Task006Test {
    @Test
    public void test() {
        assertTrue(isPermutation("cat", "act"));
        assertFalse(isPermutation("cat", "apt"));
        assertTrue(isPermutation2("cat", "act"));
        assertFalse(isPermutation2("cat", "apt"));
    }
}