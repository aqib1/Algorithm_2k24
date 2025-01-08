package org.algorithms.io.bst;

class KthLargest {
    public static void main(String[] args) {
        var kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
    }
    static class Node {
        Node left;
        Node right;
        int val;
        int count;

        Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public Node insert(Node root, int val) {
        if (root == null)
            return new Node(val, 1);

        if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        root.count++;
        return root;
    }

    private Node root;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
            root = insert(root, num);
        }
    }

    // Time OLog(n)
    // Space O(n)
    public int add(int val) {
        root = insert(root, val);
        return search(root, k);
    }

    private int search(Node root, int k) {
        int rightCount = root.right != null ? root.right.count : 0;

        if(k == rightCount + 1) {
            return root.val;
        }
        if(k > rightCount) {
            return search(root.left, k - rightCount - 1);
        } else {
            return search(root.right, k);
        }
    }
}
