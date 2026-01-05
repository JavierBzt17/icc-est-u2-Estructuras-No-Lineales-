package structures.trees;

import structures.nodes.Node;

public class IntTree {

    private Node<Integer> root;

    public IntTree() {
        this.root = null;
    }

    public void insert(int value){
        root = insertRecursive(root, value);
    }

    private Node<Integer> insertRecursive (Node<Integer> current, int value){
        if (current == null){
            return new Node<>(value);
        }

        if (value < current.getValue()){
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()){
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public void preOrder () {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node<Integer> node){
        if (node != null){
            System.out.println(node.getValue() + " ");
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<Integer> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.println(node.getValue() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    public void posOrder() {
        posOrderRecursive(root);
    }

    private void posOrderRecursive(Node<Integer> node) {
        if (node != null) {
            posOrderRecursive(node.getLeft());
            posOrderRecursive(node.getRight());
            System.out.println(node.getValue() + " ");
        }
    }

    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
    }
}