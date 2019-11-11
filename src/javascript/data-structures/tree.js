class Node {
    constructor(data) {
        this.data = data;
        this.children = [];
    }

    add(data) {
        this.children.push(new Node(data));
    }

    remove(data) {
        this.children = this.children.filter(node => node.data !== data);
    }
}

class Tree {
    constructor() {
        this.root = null;
    }

    traverseBF(fn) {
        const arr = [this.root];

        while (arr.length) {
            const node = arr.shift();
            arr.push(...node.children);
            fn(node);
        }
    }

    traverseDF(fn) {
        const arr = [this.root];

        while (arr.length) {
            const node = arr.shift();
            arr.unshift(...node.children);
            fn(node);
        }
    }
}

let node = new Node(1);
node.add(2);
node.add(3);

let node2 = new Node(4);
let node3 = new Node(5);

let node4 = new Node(6);
let node5 = new Node(7);

node.children[0].children.push(node2);
node.children[0].children.push(node3);

node.children[1].children.push(node4);
node.children[1].children.push(node5);

let tree = new Tree();
tree.root = node;

tree.traverseBF((node) => console.log(node.data)); // 1 2 3 4 5 6 7
tree.traverseDF((node) => console.log(node.data)); // 1 2 4 5 3 6 7






