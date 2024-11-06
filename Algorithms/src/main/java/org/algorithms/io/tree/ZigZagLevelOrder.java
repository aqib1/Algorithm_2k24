package org.algorithms.io.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> response = new ArrayList<>();
        var leftToRight = new Stack<TreeNode>();
        var rightToLeft = new Stack<TreeNode>();
        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();
        rightToLeft.push(root);
        while(!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            if(!rightToLeft.isEmpty()) {
                var current = rightToLeft.pop();
                if(!Objects.isNull(current)) {
                    right.add(current.val);
                    leftToRight.push(current.left);
                    leftToRight.push(current.right);
                }
            } else {
                if(!right.isEmpty()) {
                    response.add(new ArrayList<>(right));
                    right.clear();
                }
                while(!leftToRight.isEmpty()) {
                    var current = leftToRight.pop();
                    if(!Objects.isNull(current)) {
                        left.add(current.val);
                        rightToLeft.push(current.right);
                        rightToLeft.push(current.left);
                    }
                }

                if(!left.isEmpty()) {
                    response.add(new ArrayList<>(left));
                    left.clear();
                }
            }
        }

        return response;
    }
}
