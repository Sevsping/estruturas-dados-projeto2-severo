public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        
        System.out.println("Altura BST: " + bst.height());
        System.out.println("Busca 40: " + bst.search(40));
        System.out.println("Busca 99: " + bst.search(99));
    }
}
