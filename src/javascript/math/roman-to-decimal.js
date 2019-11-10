// Given a Romal numeral, the task is to find its corresponding decimal value.

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

let romansToDecimals = new Map();

romansToDecimals.set('I', 1);
romansToDecimals.set('V', 5);
romansToDecimals.set('X', 10);
romansToDecimals.set('L', 50);
romansToDecimals.set('C', 100);
romansToDecimals.set('D', 500);
romansToDecimals.set('M', 1000);

function convertRomanToDecimal(romanNumber) {
    let number = 0;

    for (let i = 0; i < romanNumber.length; i++) {
        const currentNumber = romansToDecimals.get(romanNumber[i]);

        if (i + 1 < romanNumber.length) {
            const nextNumber = romansToDecimals.get(romanNumber[i + 1]);

            if (currentNumber >= nextNumber) {
                number += currentNumber;
            } else {
                number += nextNumber - currentNumber;
                i++;
            }

        } else {
            number += currentNumber;
            i++;
        }
    }

    return number;
}
