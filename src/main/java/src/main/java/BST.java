class BST {
    Node root;
    
    void insert(int key) {
        root = insertRec(root, key);
    }
    
    Node insertRec(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insertRec(node.left, key);
        else if (key > node.key) node.right = insertRec(node.right, key);
        return node;
    }
    
    boolean search(int key) {
        return searchRec(root, key);
    }
    
    boolean searchRec(Node node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key ? searchRec(node.left, key) : searchRec(node.right, key);
    }
    
    int height() {
        return heightRec(root);
    }
    
    int heightRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }
    
    void delete(int key) {
        root = deleteRec(root, key);
    }
    
    Node deleteRec(Node node, int key) {
        if (node == null) return node;
        if (key < node.key) node.left = deleteRec(node.left, key);
        else if (key > node.key) node.right = deleteRec(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.key = minValue(node.right);
            node.right = deleteRec(node.right, node.key);
        }
        return node;
    }
    
    int minValue(Node node) {
        int min = node.key;
        while (node.left != null) {
            node = node.left;
            min = node.key;
        }
        return min;
    }
}
