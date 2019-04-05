package ru.pchurzin.unilecs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://telegra.ph/Task-15-Obem-vody-v-gistogramme-10-04
 * <p>
 * Объем воды в гистограмме
 */

class Task015 {
    static int getVolume(int[] histogram) {
        List<Integer> localMaximums = getLocalMaximums(histogram);
        if (localMaximums.size() < 2) {
            return 0;
        }
        int volume = 0;
        int leftLocalMaximumIndex = 0;
        while (leftLocalMaximumIndex < localMaximums.size() - 1) {
            int rightLocalMaximumIndex = leftLocalMaximumIndex + 1;
            int leftBound = localMaximums.get(leftLocalMaximumIndex);
            int rightBound = localMaximums.get(rightLocalMaximumIndex);
            while (rightLocalMaximumIndex < localMaximums.size() - 1 && histogram[leftBound] > histogram[rightBound]) {
                rightBound = localMaximums.get(++rightLocalMaximumIndex);
            }
            int level = Math.min(histogram[leftBound], histogram[rightBound]);
            for (int i = leftBound + 1; i < rightBound; i++) {
                if (histogram[i] < level) {
                    volume += level - histogram[i];
                }
            }
            leftLocalMaximumIndex = rightLocalMaximumIndex;
        }
        return volume;
    }

    private static List<Integer> getLocalMaximums(int[] histogram) {
        List<Integer> result = new ArrayList<>();
        boolean goingUp = true;
        for (int i = 1; i < histogram.length; i++) {
            int delta = histogram[i] - histogram[i - 1];
            if (delta < 0) {
                if (goingUp) {
                    result.add(i - 1);
                    goingUp = false;
                }
            } else {
                goingUp = true;
            }
        }
        if (goingUp && (0 - histogram[histogram.length - 1] < 0)) {
            result.add(histogram.length - 1);
        }
        return result;
    }
}
