class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    insert(data) {
        if (data < this.data && this.left) {
            this.left.insert(data);
        } else if (data < this.data) {
            this.left = new Node(data);
        } else if (data > this.data && this.right) {
            this.right.insert(data);
        } else if (data > this.data) {
            this.right = new Node(data);
        }
    }

    contains(data) {
        if (this.data === data) {
            return this;
        }

        if (data < this.data && this.left) {
            return this.left.contains(data);
        } else if (data > this.data && this.right) {
            return this.right.contains(data);
        }

        return null;
    }

    /* goes through all the left nodes first, then the right of the last node, then hits the bottom, returns true,
        which makes it go back to the previous nod, checks all the right nodes of the left branch up to the root, then
        goes to the right, doing the same. if a false is ever returned, that cascaded through the stack, and returned.

        the trick is that max will be the value of the left node, min of the right node.
     */
    validate(node, min = null, max = null) {
        if (max !== null && node.data > max) { // left side
            return false;
        }

        if (min !== null && node.data < min) { // right side
            return false;
        }

        if (node.left && !this.validate(node.left, min, node.data)) { // left side
            return false;
        }

        if (node.right && !this.validate(node.right, node.data, max)) { // right side
            return false;
        }

        return true;
    }

}
