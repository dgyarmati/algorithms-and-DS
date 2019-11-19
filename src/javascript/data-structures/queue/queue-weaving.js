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
        return this.array[this.array.length - 1];
    }
}

function weave(queue1, queue2) {
    const weaved = new Queue();

    while (queue1.peek() || queue2.peek()) {
        if (queue2.peek()) {
            weaved.enqueue(queue2.dequeue());
        }
        if (queue1.peek()) {
            weaved.enqueue(queue1.dequeue());
        }
    }

    return weaved;
}

const q1 = new Queue();
q1.enqueue('Hi');
q1.enqueue('To');
q1.enqueue('You');
q1.enqueue('Mate');

const q2 = new Queue();
q2.enqueue(1);
q2.enqueue(2);
q2.enqueue(3);

console.log(weave(q1, q2).array);
