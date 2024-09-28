package org.algorithms.io.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsBSTTree {
    private final List<Integer> inOrder;
    public IsBSTTree() {
        this.inOrder = new ArrayList<>();
    }

    public void inOrder(Node root) {
        if(Objects.isNull(root)) return;
        inOrder(root.left());
        inOrder.add(root.data());
        inOrder(root.right());
    }

    public boolean isBST(Node root) {
        inOrder(root);
        for(int i = 0; i < inOrder.size() - 1; i++) {
            if(inOrder.get(i) >= inOrder.get(i + 1))
                return false;
        }
        return true;
    }
}
