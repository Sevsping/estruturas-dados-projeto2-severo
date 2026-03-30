class BST {
    Node root;
    
        void insert(int key) {
        root = insert(root, key);
    }
    
       Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        return node;
    }
    
       boolean search(int key) {
        Node node = root;
        while (node != null) {
            if (key == node.key) return true;
            node = key < node.key ? node.left : node.right;
        }
        return false;
    }
    
        int height() {
        return height(root);
    }
    
        int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

public void delete(int key) {
    root = delete(root, key);
}

private Node delete(Node node, int key) {
    if (node == null) return node;
    
    if (key < node.key) 
        node.left = delete(node.left, key);
    else if (key > node.key) 
        node.right = delete(node.right, key);
    else {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        
        node.key = minValue(node.right);
        node.right = delete(node.right, node.key);
    }
    return node;
}

private int minValue(Node node) {
    int min = node.key;
    while (node.left != null) {
        node = node.left;
        min = node.key;
    }
    return min;
}
