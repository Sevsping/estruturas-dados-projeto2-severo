class AVLNode {
    int key, height;
    AVLNode left, right;
    AVLNode(int key) { 
        this.key = key; 
        height = 1; 
    }
}

class AVL {
    AVLNode root;
    
    int height(AVLNode n) { return n == null ? 0 : n.height; }
    
    int getBalance(AVLNode n) { return height(n.left) - height(n.right); }
    
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode t = x.right;
        x.right = y; y.left = t;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode t = y.left;
        y.left = x; x.right = t;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    
    AVLNode insert(AVLNode node, int key) {
        if (node == null) return new AVLNode(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        else return node;
        
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        
        if (balance > 1 && key < node.left.key) return rightRotate(node);
        if (balance < -1 && key > node.right.key) return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    
    void insert(int key) { root = insert(root, key); }
    
    boolean search(int key) {
        AVLNode node = root;
        while (node != null) {
            if (key == node.key) return true;
            node = key < node.key ? node.left : node.right;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.insert(10); tree.insert(20); tree.insert(30);
        System.out.println("Busca 20: " + tree.search(20));
        System.out.println("Altura AVL: " + tree.height(tree.root));
    }
}
