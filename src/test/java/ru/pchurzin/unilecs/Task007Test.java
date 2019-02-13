package ru.pchurzin.unilecs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static ru.pchurzin.unilecs.Task007.getWordListOrderedByWordLength;

public class Task007Test {
    @Test
    public void test() {
        List<String> words = getWordListOrderedByWordLength("вывести слова из строки в порядке убывания их длины");
        String[] expected = {
                "убывания",
                "вывести",
                "порядке",
                "строки",
                "слова",
                "длины",
                "из",
                "их",
                "в"
        };
        assertArrayEquals(expected, words.toArray());
    }
}