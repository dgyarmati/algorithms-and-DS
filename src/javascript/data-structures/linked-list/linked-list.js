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
        let current = this.head;
        let size = 0;

        while (current) {
            size++;
            current = current.next;
        }

        return size;
    }

}

const linkedList = new LinkedList();
linkedList.insertFirst(5);
linkedList.insertFirst(15);
console.log(linkedList);
console.log(linkedList.size());
