class Node {

    constructor(data, next = null) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
    }

    insertFirst(data) {
        this.head = new Node(data, this.head);
    }

    size() {
        let counter = 0;
        let node = this.head;

        while (node) {
            counter++;
            node = node.next;
        }

        return counter;
    }

    getFirst() {
        return this.head;
    }

    getLast() {
        if (!this.head) {
            return null;
        }

        let node = this.head;
        while (node) {
            if (!node.next) {
                return node;
            }
            node = node.next;
        }
    }

    clear() {
        this.head = null;
    }

    removeFirst() {
        if (!this.head) {
            return;
        }

        this.head = this.head.next;
    }

    removeLast() {
        if (this.head) {
            if (this.head.next) {
                let previous = this.head;
                let current = this.head.next;

                while (current.next) {
                    previous = current;
                    current = current.next;
                }

                previous.next = null;
            } else {
                this.head = null;
            }
        }
    }

    insertLast(data) {
        if (this.head) {
            let previous = this.head;
            let current = this.head.next;

            while (current) {
                previous = current;
                current = current.next;
            }

            previous.next = new Node(data, null);
        } else {
            this.head = new Node(data, null);
        }
    }

    getAt(index) {
        if (index >= 0) {
            let idx = 0;
            let node = this.head;
            const size = this.size();

            while (idx < size && idx !== index) {
                node = node.next;
                idx++;
            }

            return idx === this.size() ? null : node;
        }
    }

    removeAt(index) {
        if (!this.head) {
            return;
        }

        if (index === 0) {
            this.head = this.head.next;
            return;
        }

        const previous = this.getAt(index - 1);
        if (!previous || !previous.next) {
            return;
        }
        previous.next = previous.next.next;
    }

    insertAt(data, index) {
        if (!this.head) {
            this.head = new Node(data);
            return;
        }

        if (index === 0) {
            this.head = new Node(data, this.head);
            return;
        }

        const previous = this.getAt(index - 1) || this.getLast();
        const node = new Node(data, previous.next);
        previous.next = node;
    }

    forEach(func) {
        let node = this.head;

        while (node) {
            func(node);
            node = node.next;
        }
    }

    *[Symbol.iterator]() {
        let node = this.head;

        while (node) {
            yield node;
            node = node.next;
        }
    }

}

function midpoint(linkedList) {
    if (linkedList.head) {
        let slow = linkedList.head;
        let fast = linkedList.head;

        while (fast.next && fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

function isCircular(linkedList) {
    if (linkedList.head) {
        let slow = linkedList.head;
        let fast = linkedList.head;

        while (fast.next && fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow === fast) {
                return true;
            }
        }

        return false;
    }
}

let ll = new LinkedList();
ll.insertLast(8);
ll.insertLast(7);
ll.insertLast(10);
ll.getLast().next = ll.head;
console.log(isCircular(ll));


