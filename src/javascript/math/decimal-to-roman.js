/*
    idea:
        - x mod y will be always equal to x if y > x; otherwise it will be smaller, which makes it easy to look up the decimal of a number.
    gotcha:
        - you need 2 array: one for decimals, one for roman numbers, equal sized. the roman numbers should be the non-trivial ones,
            and the decimals should be their values.
        - you need two loops: one to go through each digit, and one to find the decimal and the corresponding roman number (for, while)
     algorithm:
        1 iterate through decimals
          2 for each decimal, check if given number mod current decimal is smaller than the number (that is, if we reached the correct decimal place)
            3 if we reached the current decimal of the number, find the corresponding roman number in the roman number array using the current index of the decimal array
            4 subtract the decimal from the number, and start over again.

 */

const decimal = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
const roman = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];

function convertDecimalToRoman(number) {
    let converted = '';

    for (let i = 0; i < decimal.length; i++) {
        while (number % decimal[i] < number) {
            converted += roman[i];
            number -= decimal[i];
        }
    }

    return converted;
}
