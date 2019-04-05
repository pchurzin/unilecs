package ru.pchurzin.unilecs;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task015Test {
    /*
           ||
           || 
           ||
           ||
     |+++++||
     |+++++||
     |+|+++|||
    ||+|+|+|||
    ||||||||||
    ||||||||||
     */
    @Test
    public void test1() {
        int[] histogram = new int[]{3, 6, 2, 4, 2, 3, 2, 10, 10, 4};
        assertEquals(17, Task015.getVolume(histogram));
    }

    /*
    ||||||||||
    ||||||||||
    ||||||||||
     */
    @Test
    public void test2() {
        int[] histogram = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        assertEquals(0, Task015.getVolume(histogram));
    }

    /*
             |
            ||
           |||
          ||||
         |||||
        ||||||
       |||||||
      ||||||||
     |||||||||
    ||||||||||
     */
    @Test
    public void test3() {
        int[] histogram = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, Task015.getVolume(histogram));
    }

    /*
        |
        |
        |
        |
        |
        |
       |||
      |||||
     |||||||
    |||||||||
     */
    @Test
    public void test4() {
        int[] histogram = new int[]{1, 2, 3, 4, 10, 4, 3, 2, 1};
        assertEquals(0, Task015.getVolume(histogram));
    }

    /*
        |
        |
        |
        |
        |
        |
    |++|||
    |+|||||++|
    ||||||||+|
    ||||||||||
     */
    @Test
    public void test5() {
        int[] histogram = new int[]{4, 2, 3, 4, 10, 4, 3, 2, 1, 3};
        assertEquals(6, Task015.getVolume(histogram));
    }
}