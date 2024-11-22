package org.algorithms.io.amazon2k24.revision;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    private static final int CHAR_LIMIT = 26;
    private boolean isEnd;
    private int end;
    private int current;
    private char key;
    private TrieNode[] nodes;

    public TrieNode() {
        nodes = new TrieNode[CHAR_LIMIT];
    }

    public List<String> findAll(String data) {
       var response = new ArrayList<String>();
       TrieNode lastNode = this;
       for(char ch: data.toCharArray()) {
          lastNode = lastNode.nodes[ch - 'a'];
          if(lastNode == null)
             return response;
       }

       findAll(lastNode, data, response);

       return response;
    }

    public void findAll(TrieNode current, String curr, ArrayList<String> response) {
       if(current == null)
          return;
       if(current.isLeaf()) {
          response.add(curr);
       }

       for(var child: current.nodes) {
          if(child != null) {
             findAll(child, curr.concat(String.valueOf(child.key)), response);
          }
       }
    }

    public void delete(String data) {
       data = data.toLowerCase();
       var current = this;
       for(char ch: data.toCharArray()) {
          int idx = ch - 'a';
          var nodeToBeRemoved = current.nodes[idx];
          if(nodeToBeRemoved == null) return;
          nodeToBeRemoved.current--;
          if(nodeToBeRemoved.current == 0) {
             current.nodes[idx] = null;
          }
          current = nodeToBeRemoved;
       }
       current.end--;
    }

    public void insert(String data) {
        data = data.toLowerCase();
        var current = this;
        for (char ch : data.toCharArray()) {
            int idx = ch - 'a';
            if (current.nodes[idx] == null) {
                current.nodes[idx] = new TrieNode();
            }
            current = current.nodes[idx];
            current.key = ch;
            current.current++;
        }

        current.end++;
        current.isEnd = true;
    }

    public boolean contains(String value) {
        value = value.toLowerCase();
        TrieNode current = this;
        for (char ch : value.toCharArray()) {
            int idx = ch - 'a';
            if (current.nodes[idx] == null) {
                return false;
            }
            current = current.nodes[idx];
        }
        return current.isEnd;
    }

    public boolean isLeaf() {
        return this.isEnd;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        toString(this, "", builder);
        return builder.toString();
    }

    public void toString(TrieNode node, String current, StringBuilder builder) {
        current = current.concat(String.valueOf(node.key));
        if (node.isLeaf()) {
            builder.append(current).append(" ");
            return;
        }

        for (int i = 0; i < node.nodes.length; i++) {
            if (node.nodes[i] != null) {
                toString(node.nodes[i], current, builder);
            }
        }
    }
}

public class TrieII {
    public static void main(String[] args) {
        String input = "hello dog hell hel hellk temp hdjdljd hkll";
        String[] data = input.split(" ");
        TrieNode node = new TrieNode();

        for (var d : data) {
            node.insert(d);
        }

        System.out.println(node);

//        node.delete("aaabba");
//
//       System.out.println(node);

       System.out.println(node.findAll("h"));
    }
}
