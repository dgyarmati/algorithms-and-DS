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

