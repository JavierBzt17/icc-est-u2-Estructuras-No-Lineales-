import structures.trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        IntTree tree = new IntTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(3);

        System.out.println("\nPreOrder:");
        tree.preOrder();

        System.out.println("\nInOrder:");
        tree.inOrder();

        System.out.println("\nPostOrder:");
        tree.postOrder();

        System.out.println("\nSize:");
        System.out.println(tree.size());
    }
}