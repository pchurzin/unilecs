import java.util.HashMap;
import java.util.Map;

/**
 * https://t.me/unilecs/19
 *
 * Первый уникальный символ в строке
 */

public class Task011 {
    public static void main(String[] args) {
        System.out.println(firstUniqueSymbol("11_22_333_4_5_4_6_7"));
    }

    private static Character firstUniqueSymbol(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (Character c :
                s.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }
        for (Character c :
                s.toCharArray()) {
            if (counter.get(c) == 1) {
                return c;
            }
        }
        return null;
    }
}
