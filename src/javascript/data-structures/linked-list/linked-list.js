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

        while (node.next) {
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
