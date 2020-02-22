package ru.pchurzin.unilecs;

public class Task020 {

    public static String pow(String string, int k) {
        if (string == null) {
            return null;
        }
        if (k == 0) {
            return "";
        }
        if (k > 0) {
            return getStringPow(string, k);
        }
        if (string.length() % k != 0) {
            return null;
        }
        String possibleRoot = string.substring(0, -k);
        if (getStringPow(possibleRoot, -k).equals(string)) {
            return possibleRoot;
        }
        return null;
    }

    public static String powA(String string, int k) {
        if (string == null) {
            return null;
        }
        if (k == 0) {
            return "";
        }
        char[] chars = string.toCharArray();
        if (k > 0) {
            char[] resultChars = new char[chars.length * k];
            for (int i = 0; i < k; i++) {
                System.arraycopy(chars, 0, resultChars, i * chars.length, chars.length);
            }
            return new String(resultChars);
        }

        if (chars.length % (-k) != 0) {
            return null;
        }

        int rootLength = - chars.length / k;
        char[] possibleRoot = new char[rootLength];
        System.arraycopy(chars, 0, possibleRoot, 0, rootLength);
        int j = 0;
        for (int i = 0; i < -k; i++, j = (j + 1) % rootLength) {
            if (chars[i * rootLength + j] != possibleRoot[j]) {
                return null;
            }
        }
        return new String(possibleRoot);
    }

    private static String getStringPow(String string, int k) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 1; i < k; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
