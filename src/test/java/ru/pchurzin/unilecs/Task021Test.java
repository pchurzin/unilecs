package ru.pchurzin.unilecs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task021Test {

    @Test
    public void findPair() {
        List<Integer> list = Arrays.asList(1, 0, 3, 4, 0, 6, 7, 8, 9, 10);
        Collections.shuffle(list);

        String pair = Task021.findPair(list.stream().mapToInt(i -> i).toArray());
        assertEquals("2,5", pair);
    }

}