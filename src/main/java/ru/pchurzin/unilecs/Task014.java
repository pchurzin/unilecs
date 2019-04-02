package ru.pchurzin.unilecs;

import java.util.Iterator;

/**
 * https://t.me/unilecs/28
 * <p>
 * Вывести слова в строке в обратном порядке
 */

public class Task014 {
    static String[] getWordsInReverseOrder(String input) {
        String[] s = input.split(" ");
        String[] result = new String[s.length];
        for (int i = s.length - 1; i >= 0; i--) {
            result[s.length - i - 1] = s[i];
        }
        return result;
    }

    static class WordReverser implements Iterable<String> {
        private char[] string;

        WordReverser(char[] input) {
            this.string = input;
        }

        @Override
        public Iterator<String> iterator() {
            return new ReverseWordIterator();
        }

        private class ReverseWordIterator implements Iterator<String> {
            private int index;

            ReverseWordIterator() {
                index = string.length - 1;
                skipSpaces();
            }

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public String next() {
                int end = index;
                skipToSpace();
                String s = new String(string, index + 1, end - index);
                skipSpaces();
                return s;
            }

            private void skipSpaces() {
                while (index >= 0 && string[index] == ' ') {
                    index--;
                }
            }

            private void skipToSpace() {
                while (index >= 0 && string[index] != ' ') {
                    index--;
                }
            }
        }
    }


}
