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
linkedList2.insertFirst(8);
linkedList2.insertFirst(9);

console.log('last item', linkedList2.getLast());
linkedList2.removeLast();
console.log(linkedList2);


