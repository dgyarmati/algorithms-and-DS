class Node {

    constructor(data, node = null) {
        this.data = data;
        this.next = node;
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
        let node = this.head;
        let size = 0;

        while (node) {
            size++;
            node = node.next;
        }

        return size;
    }

    getFirst() {
        return this.head;
    }

    getLast() {
        let node = this.head;

        while (node && node.next) {
            node = node.next;
        }

        return node;
    }

    clear() {
        this.head = null;
    }

    removeFirst() {
        if (this.head) {
            this.head = this.head.next;
        } else {
            this.clear();
        }
    }

    removeLast() {
        if (!this.head.next) {
            this.head = null;
            return;
        }

        let node = this.head;

        while (node.next && node.next.next) {
            node = node.next;
        }

        node.next = null;
    }

    insertLast(data) {
        let lastNode = this.getLast();

        if (lastNode) {
            lastNode.next = new Node(data, null);
        } else {
            this.insertFirst(data);
        }
    }

    getAt(index) {
        if (index > this.size() - 1) {
            return null;
        }

        let idx = 0;
        let node = this.head;

        while (node && node.next) {
            if (index === idx) {
                return node;
            }
            idx++;
            node = node.next;
        }

        return node;
    }

}

const linkedList = new LinkedList();
linkedList.insertFirst(5);
linkedList.insertFirst(15);
linkedList.insertFirst(20);
console.log(linkedList);
console.log(linkedList.size());
console.log(linkedList.getFirst());
console.log('last item', linkedList.getLast());
//linkedList.clear();
//console.log(linkedList);
//linkedList.removeFirst();
//console.log(linkedList);
//linkedList.removeLast();
//console.log(linkedList);

const linkedList2 = new LinkedList();
linkedList2.insertLast(18);
linkedList2.insertLast(20);
console.log(linkedList2);
console.log(linkedList2.getAt(1));
console.log(linkedList2.getAt(2));



