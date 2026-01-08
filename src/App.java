import java.util.List;
import models.Person;
import structures.graphs.Graph;
import structures.nodes.Node;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        runTree();
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
        
        runGraph();
    }

    private static void runTree(){
        Tree<Person> tree = new Tree<Person>();
        tree.insert(new Person("Pablo", 21));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Ana", 25));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Luis", 19 ));
        tree.insert(new Person("Pedro", 23));
        tree.inOrder(); 

        Person findPerson = tree.searchByAge(23);
        if (findPerson != null) {
            System.out.println(findPerson);
        } else {
            System.out.println("No se encontro");
        }
    }

    private static void runGraph(){
        Graph<String> graph = new Graph<>();

        Node<String> nA = new Node<String>("A");
        Node<String> nB = new Node<String>("B");
        Node<String> nC = new Node<String>("C");
        Node<String> nD = new Node<String>("D");
        
        graph.addNode(nA);

        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nD);
        graph.addEdge(nC, nD);

        graph.printGraph();

        //Conectados de A 
        List<Node<String>> neighbors = graph.getNeighbors(nA);
        System.out.println("Neighbors de A: ");
        for (Node<String> neighbor : neighbors) {
            System.out.println(neighbor + " ");
        }
    }
}