package ru.pchurzin.unilecs;

/**
 * https://telegra.ph/Task-15-Obem-vody-v-gistogramme-10-04
 * <p>
 * Объем воды в гистограмме
 */

class Task015 {
    static int getVolume(int[] histogram) {
        int[] leftLocalMaximums = new int[histogram.length];
        int[] rightLocalMaximums = new int[histogram.length];
        int currentLeftMax = 0;
        int currentRightMax = 0;

        //считаем для каждой точки гистограммы локальные максимумы слева и справа
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > currentLeftMax) {
                currentLeftMax = histogram[i];
            }
            leftLocalMaximums[i] = currentLeftMax;
            if (histogram[histogram.length - 1 - i] > currentRightMax) {
                currentRightMax = histogram[histogram.length - 1 - i];
            }
            rightLocalMaximums[histogram.length - 1 - i] = currentRightMax;
        }

        int volume = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (leftLocalMaximums[i] <= rightLocalMaximums[i]) {
                volume += leftLocalMaximums[i] - histogram[i];
            } else {
                volume += rightLocalMaximums[i] - histogram[i];
            }
        }
        return volume;
    }
}
