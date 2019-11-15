class Node {
    constructor(data) {
        this.data = data;
        this.children = [];
    }

    add(data) {
        this.children.push(new Node(data));
    }
}

function getLevelWidths(root) {
    let nodes = [root, 's'];
    const levelWidths = [0];

    while (nodes.length > 1) {
        const node = nodes.shift();

        if (node === 's') {
            levelWidths.push(0);
            nodes.push('s');
        } else {
            nodes.push(...node.children);
            levelWidths[levelWidths.length - 1]++;
        }
    }

    return levelWidths;
}

let root = new Node(1);
root.add(2);
root.add(3);

let node2 = new Node(4);
let node3 = new Node(5);

let node4 = new Node(6);
let node5 = new Node(7);

root.children[0].children.push(node2);
root.children[0].children.push(node3);

root.children[1].children.push(node4);
root.children[1].children.push(node5);

console.log(getLevelWidths(root));

