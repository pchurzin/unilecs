package ru.pchurzin.unilecs;

/**
 * https://t.me/unilecs/22
 * <p>
 * Написать функцию, ктр "сжимает" строку.
 * Если полученная строка оказалась больше исходной, то вывести исходную.
 * Например, дана строка "ZZZABBEEE", получить строку вида "Z3A1B2E3",
 * т.е. подставить счетчик вхождения символа
 */

class Task013 {
    static String compress(String input) {
        StringBuilder sb = new StringBuilder();
        char current = input.charAt(0);
        int counter = 1;
        for (int i = 1; i < input.toCharArray().length; i++, counter++) {
            if (input.charAt(i) != current) {
                sb.append(current).append(counter);
                current = input.charAt(i);
                counter = 0;
            }
        }
        sb.append(current).append(counter);
        return sb.length() < input.length() ? sb.toString() : input;
    }
}
