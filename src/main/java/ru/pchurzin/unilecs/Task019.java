package ru.pchurzin.unilecs;

/**
 * https://telegra.ph/Task-19-Najti-slovo-v-simvolnoj-matrice-10-10
 * <p>
 * Найти слово в символьной матрице
 */
public class Task019 {
    static boolean isWordInMatrix(char[][] matrix, CharSequence word) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                boolean found =
                        isWordInSequence(matrix, row, col, 1, 0, word) ||
                        isWordInSequence(matrix, row, col, -1, 0, word) ||
                        isWordInSequence(matrix, row, col, 0, 1, word) ||
                        isWordInSequence(matrix, row, col, 0, -1, word) ||
                        isWordInSequence(matrix, row, col, 1, 1, word) ||
                        isWordInSequence(matrix, row, col, 1, -1, word);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isWordInSequence(char[][] matrix, int x, int y, int dx, int dy, CharSequence word) {
        for (int i = 0; i < word.length(); i++) {
            if (!isCharEquals(matrix, x + i * dy, y + i * dx, word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCharEquals(char[][] matrix, int row, int col, char c) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        }
        return matrix[row][col] == c;
    }
}
