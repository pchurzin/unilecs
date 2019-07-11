package ru.pchurzin.unilecs;

import org.junit.Assert;
import org.junit.Test;

public class Task019Test {

    @Test
    public void isWordInMatrix() {
        char[][] matrix = new char[][]{
                new char[]{'a', 'c', 'r', 'd'},
                new char[]{'d', 't', 'r', 'a'},
                new char[]{'v', 'i', 'o', 'd'},
                new char[]{'b', 'y', 'l', 's'},
                new char[]{'o', 't', 'k', 'e'},
        };

        Assert.assertTrue(Task019.isWordInMatrix(matrix, "art"));
        Assert.assertTrue(Task019.isWordInMatrix(matrix, "bird"));
        Assert.assertTrue(Task019.isWordInMatrix(matrix, "dil"));
        Assert.assertTrue(Task019.isWordInMatrix(matrix, "b"));
        Assert.assertFalse(Task019.isWordInMatrix(matrix, "notsuchword"));
    }
}