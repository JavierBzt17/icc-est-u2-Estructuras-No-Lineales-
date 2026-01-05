package structures.trees;

import structures.nodes.Node;

public class IntTree {

    private Node<Integer> root;
    private int size;

    public IntTree() {
        this.root = null;
        this.size = 0;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node<Integer> insertRecursive(Node<Integer> current, int value) {
        if (current == null) {
            size++;
            return new Node<>(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node<Integer> node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }

    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node<Integer> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    public void postOrder() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node<Integer> node) {
        if (node != null) {
            postOrderRecursive(node.getLeft());
            postOrderRecursive(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public int size() {
        return this.size;
    }
}