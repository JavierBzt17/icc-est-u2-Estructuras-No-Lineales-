package structures.trees;

import structures.nodes.Node;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T value) {
        this.root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }
}