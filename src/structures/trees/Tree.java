package structures.trees;

import structures.nodes.Node;
import java.util.Stack;

import models.Person;

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
            return new Node<T>(value);
        }


        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public void inOrder() {
        if (root == null) return;

        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            current = stack.pop();
            System.out.println(current.getValue());
            current = current.getRight();
        }
    
    }

    public void inOrderRecursive(Node<T> node) {
        if (node == null) return;

        inOrderRecursive(node.getLeft());
        System.out.println(node.getValue());
        inOrderRecursive(node.getRight());
        
    }

    public T search(T value) {
        return searchRecursive(root, value);
    }

    public T searchRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value.equals(current.getValue())) {
            return current.getValue();
        }

        if (value.compareTo(current.getValue()) < 0) {
            return searchRecursive(current.getLeft(), value);
        } else {
            return searchRecursive(current.getRight(), value);
        }

    }


    public T searchByAge(int age) {
        return searchByAgeRecursive(root, age);
    }

    private T searchByAgeRecursive(Node<T> current, int age) {
        if (current == null) {
            return null;
        }

        Person persona = (Person) current.getValue();
        if (age == persona.getAge()) {
            return current.getValue();
        }
        if (age < persona.getAge()) {
            return searchByAgeRecursive(current.getLeft(), age);
        } 
        else {
            return searchByAgeRecursive(current.getRight(), age);
        }
    }
}