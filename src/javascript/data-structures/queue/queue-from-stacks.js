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
        return this.array[this.array.length - 1];
    }

}

class Queue {

    constructor(props) {
        this.first = new Stack();
        this.second = new Stack();
    }

    enqueue(item) {
        this.first.push(item);
    }

    dequeue() {
        while (this.first.peek()) {
            this.second.push(this.first.pop());
        }

        const value = this.second.pop();

        while (this.second.peek()) {
            this.first.push(this.second.pop());
        }

        return value;
    }

    peek() {
        while (this.first.peek()) {
            this.second.push(this.first.pop());
        }

        const value = this.second.peek();

        while (this.second.peek()) {
            this.first.push(this.second.pop());
        }

        return value;
    }

}
