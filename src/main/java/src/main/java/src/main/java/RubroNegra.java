enum Cor { VERMELHA, PRETA }

class NoRN {
    int key;
    NoRN left, right, parent;
    Cor cor;
    NoRN(int key) { 
        this.key = key; 
        cor = Cor.VERMELHA; 
    }
}

class RubroNegra {
    NoRN root, NIL;
    
    RubroNegra() {
        NIL = new NoRN(0);
        NIL.cor = Cor.PRETA;
        NIL.left = NIL.right = NIL;
        root = NIL;
        root.cor = Cor.PRETA;
    }
    
    void rotateLeft(NoRN x) {
        NoRN y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == NIL) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }
    
    void rotateRight(NoRN x) {
        NoRN y = x.left;
        x.left = y.right;
        if (y.right != NIL) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == NIL) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;
        y.right = x;
        x.parent = y;
    }
    
    void insert(int key) {
        NoRN node = new NoRN(key);
        NoRN parent = NIL, x = root;
        while (x != NIL) {
            parent = x;
            if (node.key < x.key) x = x.left;
            else x = x.right;
        }
        node.parent = parent;
        if (parent == NIL) root = node;
        else if (node.key < parent.key) parent.left = node;
        else parent.right = node;
        node.left = node.right = NIL;
        node.cor = Cor.VERMELHA;
        fixInsert(node);
    }
    
    void fixInsert(NoRN z) {
        while (z.parent.cor == Cor.VERMELHA) {
            if (z.parent == z.parent.parent.right) {
                NoRN y = z.parent.parent.left;
                if (y.cor == Cor.VERMELHA) {
                    y.cor = Cor.PRETA;
                    z.parent.cor = Cor.PRETA;
                    z.parent.parent.cor = Cor.VERMELHA;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rotateRight(z);
                    }
                    z.parent.cor = Cor.PRETA;
                    z.parent.parent.cor = Cor.VERMELHA;
                    rotateLeft(z.parent.parent);
                }
            } else {
                NoRN y = z.parent.parent.right;
                if (y.cor == Cor.VERMELHA) {
                    y.cor = Cor.PRETA;
                    z.parent.cor = Cor.PRETA;
                    z.parent.parent.cor = Cor.VERMELHA;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        rotateLeft(z);
                    }
                    z.parent.cor = Cor.PRETA;
                    z.parent.parent.cor = Cor.VERMELHA;
                    rotateRight(z.parent.parent);
                }
            }
            if (z == root) break;
        }
        root.cor = Cor.PRETA;
    }
    
    boolean search(int key) {
        NoRN node = root;
        while (node != NIL) {
            if (key == node.key) return true;
            node = key < node.key ? node.left : node.right;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        RubroNegra tree = new RubroNegra();
        tree.insert(10); tree.insert(20);
        System.out.println("Busca 20: " + tree.search(20)); // true
    }
}
