package ru.pchurzin.unilecs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://t.me/unilecs/13
 * вывести слова из строки в порядке убывания их длины
 */

public class Task007 {
    public static void main(String[] args) {
        for (String s :
                getWordListOrderedByWordLength("вывести слова из строки в порядке убывания их длины")) {
            System.out.println(s);
        }
    }

    private static List<String> getWordListOrderedByWordLength(String s) {
        List<String> words = Arrays.asList(s.split(" "));
        words.sort(Comparator.comparingInt(String::length).reversed());
        return words;
    }
}
