package ru.pchurzin.unilecs;

import java.util.HashMap;
import java.util.Map;

public class Task205 {

    private static final Map<Character, Integer> DIGIT_MAP = new HashMap<>();

    static {
        DIGIT_MAP.put('0', 0);
        DIGIT_MAP.put('1', 1);
        DIGIT_MAP.put('2', 2);
        DIGIT_MAP.put('3', 3);
        DIGIT_MAP.put('4', 4);
        DIGIT_MAP.put('5', 5);
        DIGIT_MAP.put('6', 6);
        DIGIT_MAP.put('7', 7);
        DIGIT_MAP.put('8', 8);
        DIGIT_MAP.put('9', 9);
    }

    public static int parseInt(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        // skip spaces
        while (chars[index] == ' ') {
            index++;
        }
        // handle possible sign
        if (chars[index] == '-') {
            sign = -1;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }
        int digitsStartAt = index;
        // count digits
        while (chars[index] >= '0' && chars[index] <= '9') {
            index++;
        }
        int digitsStopAt = index - 1;
        if (digitsStopAt < digitsStartAt) {
            // we have no digits
            return 0;
        }
        int sum = sign * DIGIT_MAP.get(chars[digitsStopAt]);
        int power = 10;
        for (int i = digitsStopAt - 1; i >= digitsStartAt; i--) {
            char currentDigit = chars[i];
            int currentPowerAmount = power * DIGIT_MAP.get(currentDigit);
            if (sum + sign * currentPowerAmount >= sign * sum) {
                // no overflow
                sum += currentPowerAmount;
            } else {
                sum = sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                break;
            }
            power *= 10;
        }
        return sum;
    }

    public static int parseInt(CharSequence charSequence) {
        return parseInt(charSequence.toString().toCharArray());
    }

}
