/**
 * https://t.me/unilecs/7
 * Заменить все пробелы в строке символами '%20'
 */
public class Task003 {
    public static void main(String[] args) {
        System.out.println(replaceSpaceBySpecialSymbols("Mr John Smith".toCharArray()));
    }

    private static char[] replaceSpaceBySpecialSymbols(char[] input) {
        int spaceCounter = 0;
        for (char c : input) {
            if (c == ' ') spaceCounter++;
        }

        char[] output = new char[input.length + spaceCounter * 2];
        int outputIndex = output.length - 1;
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                output[outputIndex] = '0';
                output[outputIndex - 1] = '2';
                output[outputIndex - 2] = '%';
                outputIndex -= 3;
            } else {
                output[outputIndex--] = input[i];
            }
        }
        return output;
    }
}
