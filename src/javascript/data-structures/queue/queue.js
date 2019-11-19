class Queue {

    constructor() {
        this.array = [];
    }

    enqueue(item) {
        this.array.push(item);
    }

    dequeue() {
        return this.array.shift();
    }

    peek() {
        return this.array.get(0);
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
