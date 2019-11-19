class Stack {

    constructor() {
        this.array = [];
    }

    push(item) {
      this.array.push(item);
    }

    pop() {
      return this.array.pop();
    }

    peek() {
        return this.array.get(this.array.length - 1);
    }

}

const s = new Stack();

s.push('fox');
s.push('bear');
s.push('whale');

console.log(s.array);

console.log(s.pop());
console.log(s.pop());
console.log(s.pop());

console.log(s.array);

s.push('fox');
s.push('bear');
console.log(s.array);


