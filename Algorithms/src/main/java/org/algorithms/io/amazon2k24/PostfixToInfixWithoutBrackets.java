package org.algorithms.io.tree;

import java.util.Stack;

public class PostfixToInfixWithoutBrackets {
    static class CharNode {
        private final char data;
        private CharNode left;
        private CharNode right;

        public CharNode(char data) {
            this.data = data;
        }

        public String toInOrderString() {
            var builder = new StringBuilder();
            inorder(builder, this);

            return builder.toString();
        }

        public static void inorder(StringBuilder builder, CharNode charNode) {
            if(charNode == null)
                return;

            inorder(builder, charNode.left);
            builder.append(charNode.data);
            inorder(builder, charNode.right);
        }
    }

    public static void main(String[] args) {
        System.out.println((getInfix("ab*c+")));
    }

    public static String getInfix(String postfix) {
        if(postfix == null || postfix.isBlank())
            return null;

        var expressionTree = expressionTree(postfix);

        return expressionTree.toInOrderString();
    }

    private static CharNode expressionTree(String exp) {
        var stack = new Stack<CharNode>();
        for(char c: exp.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                stack.add(new CharNode(c));
            } else {
                var operatorNode = new CharNode(c); // leaf nodes
                var leftOperand = stack.pop();
                var rightOperand = stack.pop();

                operatorNode.left = leftOperand;
                operatorNode.right = rightOperand;

                stack.push(operatorNode);
            }
        }
        return stack.pop();
    }
}
