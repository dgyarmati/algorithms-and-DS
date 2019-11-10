// Given a Romal numeral, the task is to find its corresponding decimal value.

/*
    the idea:
        we know that there are unique roman numerals marking 'turning points', and we also know that some values put before others
        lessen the value of the other. for example, IV = 5 - 1 = 4. so:
        - put the 'turning numbers' and their values to a map
        - add an index to each, so that you can check if they are next to each other, and if they are, subtract, otherwise add to a sum
    the gotchas:
        - you need to iterate in pairs
        - BUT you need to go one by one still (i++ instead of i+=2), because if you go by pairs, you can end up
            skipping values - for example, MMCDLIV is 3454, but going in pairs, you jump over CD, which would be 400, getting the incorrect value
    algorithm:
        0. initialize sum value
        1. for each character in numeral string, starting from the last
            2. if this is the last character, look it up in the map, and add it to sum
            3. else take the current and the next character, and check if they are next to each other
                4. if true: subtract current character's value from sum
                4. if false: add current caharacter's value to sum
 */

let romanNumerals = new Map();

romanNumerals.set('I', {index: 1, value: 1});
romanNumerals.set('V', {index: 2, value: 5});
romanNumerals.set('X', {index: 3, value: 10});
romanNumerals.set('L', {index: 4, value: 50});
romanNumerals.set('C', {index: 5, value: 100});
romanNumerals.set('D', {index: 6, value: 500});
romanNumerals.set('M', {index: 7, value: 1000});

function convertRomanToInteger(romanNumeral) {
    let number = 0;
    for (let i = romanNumeral.length - 1; i >= 0; i--) {
        const current = romanNumeral[i];
        const currentNumeral = romanNumerals.get(current);
        if (i === romanNumeral.length - 1) {
            number += currentNumeral.value;
        } else {
            const next = romanNumeral[i + 1];
            const nextNumeral = romanNumerals.get(next);

            if (nextNumeral.index - currentNumeral.index === 1) {
                number -= currentNumeral.value;
            } else {
                number += currentNumeral.value;
            }
        }
    }
    return number;
}
