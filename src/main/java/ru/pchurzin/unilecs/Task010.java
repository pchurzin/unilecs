package ru.pchurzin.unilecs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://t.me/unilecs/18
 *
 * Если элемент матрицы равен 0, то всю строку и весь столбец нужно обнулить
 */
public class Task010 {
    public static void main(String[] args) {
        int[][] m = {
                {-1,  2, 4, 0,  7},
                { 0, -2, 2, 5,  7},
                { 1,  1, 1, 1, -9},
                { 1,  3,-3, 0,  7},
        };
        printMatrix(m);
        changeMatrix(m);
        printMatrix(m);
    }

    static void changeMatrix(int[][] matrix) {
        List<Integer> rowsToBeChanged = new ArrayList<>();
        List<Integer> colsToBeChanged = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    rowsToBeChanged.add(row);
                    colsToBeChanged.add(col);
                }
            }
        }
        for (int row : rowsToBeChanged) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
        for (int col : colsToBeChanged) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
