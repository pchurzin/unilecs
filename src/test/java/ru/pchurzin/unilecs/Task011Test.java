package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.pchurzin.unilecs.Task011.firstUniqueSymbol;

public class Task011Test {
    @Test
    public void test() {
        assertEquals(Character.valueOf('5'), firstUniqueSymbol("  11_22_333_4_5_4_6_7"));
    }
}