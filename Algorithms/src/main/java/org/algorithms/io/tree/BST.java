package org.algorithms.io.tree;

public class BST {

    public static void main(String[] args) {
        var bst = new BST();
        bst.add(50);
        bst.add(10);
        bst.add(3);
        bst.add(2);
        bst.add(61);
        bst.add(-1);

        System.out.println(bst);
        System.out.println(bst.isValidBst());
    }

    private Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            add(value, root);
        }


        return true;
    }

    public boolean isValidBst() {
        return validateBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBst(Node current, int low, int high) {
        if(current == null) return true;
        if(current.getData() <= low || current.getData() >= high) return false;

        return validateBst(current.getLeft(), low, current.getData()) &&
                validateBst(current.getRight(), current.getData(), high);
    }


    public void add(int value, Node current) {
        if (value > current.getData()) {
            if(current.getRight() == null) {
                current.setRight(
                        new Node(value)
                );
            } else {
                add(value, current.getRight());
            }
        } else {
            if(current.getLeft() == null) {
                current.setLeft(
                        new Node(value)
                );
            } else {
                add(value, current.getLeft());
            }
        }
    }

    @Override
    public String toString() {
        return inOrder(root, new StringBuilder());
    }

    private String inOrder(Node root, StringBuilder builder) {
        if(root == null) return builder.toString();

        inOrder(root.getLeft(), builder);
        builder.append(root.getData()).append(" ");
        inOrder(root.getRight(), builder);

        return builder.toString();
    }
}
