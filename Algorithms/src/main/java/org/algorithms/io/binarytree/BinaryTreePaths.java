package org.algorithms.io.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        var response = new ArrayList<String>();
        var current = new ArrayList<Integer>();
        binaryTreePaths(root, current, response);
        return response;
    }

    public void binaryTreePaths(
            TreeNode root,
            ArrayList<Integer> current,
            ArrayList<String> response
    ) {
        if(root == null)
            return;

        current.add(root.val);

        if(root.left == null && root.right == null) {
            response.add(current.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("->"))
            );
        }

        binaryTreePaths(root.left, current, response);
        binaryTreePaths(root.right, current, response);

        current.removeLast();
    }
}
