package java.uncategorized;

import java.util.HashMap;
import java.util.Map;

/*
    idea:
        - iterate through the roman characters in pairs, and get their respective integer values from a map.
            if the current value is bigger or equal to the next one, then add the current number to the sum. (A)
            otherwise, subtract the current value from the next value, and add the result to the sum. (B)
    gotchas:
        - since you iterate in pairs, you need to check if the next value would be outside of the array (C)
        - in B case, you resolved a two-digit numeral, so to speak, so you can skip to the next pair by increasing the counter - otherwise, progress normally
        - in C case, there will be no more pairs for sure, so you can add the current value to the sum, and increase the counter, thus ending the loop
 */

public class RomanToDecimal {

    private static Map<Character, Integer> createRomanToDecimalMap() {
        Map<Character, Integer> romanToDecimal = new HashMap<>();
        romanToDecimal.put('I', 1);
        romanToDecimal.put('V', 5);
        romanToDecimal.put('X', 10);
        romanToDecimal.put('L', 50);
        romanToDecimal.put('C', 100);
        romanToDecimal.put('D', 500);
        romanToDecimal.put('M', 1000);
        return romanToDecimal;
    }

    static int convertRomanToDecimal(String romanNumber, Map<Character, Integer> romanToDecimalMap) {
        int decimal = 0;

        for (int i = 0; i < romanNumber.length(); i++) {
            int currentDecimal = romanToDecimalMap.get(romanNumber.charAt(i));

            if (i + 1 < romanNumber.length()) {
                int nextDecimal = romanToDecimalMap.get(romanNumber.charAt(i + 1));

                if (currentDecimal >= nextDecimal) {
                    decimal += currentDecimal;
                } else {
                    decimal += nextDecimal - currentDecimal;
                    i++;
                }
            } else {
                decimal += currentDecimal;
                i++;
            }
        }

        return decimal;
    }

}
