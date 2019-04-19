package ru.pchurzin.unilecs;

import org.junit.Assert;
import org.junit.Test;

public class Task018Test {

    @Test
    public void getNonPairedElement() {
        Assert.assertEquals(5, Task018.getNonPairedElement(new int[]{0, 4, -1, 5, -1, 4, 0}));
    }
}