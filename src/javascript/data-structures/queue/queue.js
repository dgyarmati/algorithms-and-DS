class Queue {

    constructor() {
        this.array = [];
    }

    enqueue(item) {
        this.array.unshift(item);
    }

    dequeue() {
        return this.array.pop();
    }

    peek() {
        return this.array[this.array.length - 1];
    }
}

const q = new Queue();
q.enqueue('fox');
q.enqueue('bear');
q.enqueue('whale');

console.log(q.array);

console.log(q.dequeue());
console.log(q.dequeue());
console.log(q.dequeue());

console.log(q.array);

q.enqueue('fox');
q.enqueue('bear');
console.log(q.array);
