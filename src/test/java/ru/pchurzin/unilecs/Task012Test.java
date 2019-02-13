package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pchurzin.unilecs.Task012.doesArrayContainsDividers;

public class Task012Test {

    @Test
    public void test() {
        assertTrue(doesArrayContainsDividers(new int[]{-1, 0, 0, 3, 3, 10}, -10)); // true
        assertFalse(doesArrayContainsDividers(new int[]{0, 3, 3, 10}, 3));          // false
        assertFalse(doesArrayContainsDividers(new int[]{1, 0, 3, 3, 9, 15}, 10));   // false
        assertFalse(doesArrayContainsDividers(new int[]{1, 0, 3, 3, 20, 8}, 10));   // false
        assertTrue(doesArrayContainsDividers(new int[]{1, 0, 3, 3, 20, 8}, 0));    // true
        assertTrue(doesArrayContainsDividers(new int[]{1, 0, -3, 3, -10}, -9));    // true
        assertFalse(doesArrayContainsDividers(new int[]{}, -9));    // false
        assertFalse(doesArrayContainsDividers(new int[]{9}, -9));    // false
    }
}