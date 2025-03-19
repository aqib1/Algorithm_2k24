package org.algorithms.io.strings;

import java.util.Stack;
public class SimplifyPath {
    public static void main(String[] args) {
        var sim = new SimplifyPath();
        System.out.println(sim.simplifyPath("/../"));
    }
    /**
     * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.
     * The rules of a Unix-style file system are as follows:
     * A single period '.' represents the current directory.
     * A double period '..' represents the previous/parent directory.
     * Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
     * Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
     * The simplified canonical path should follow these rules:
     * The path must start with a single slash '/'.
     * Directories within the path must be separated by exactly one slash '/'.
     * The path must not end with a slash '/', unless it is the root directory.
     * The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
     * Return the simplified canonical path.
     * */
    // Time complexity O(n) and space complexity O(n)
    public String simplifyPath(String path) {
        if(path == null || path.isBlank()) {
            return "";
        }
        var dataSplit = path.split("/");
        var stack = new Stack<String>();

        for(var data : dataSplit) {
            if(data.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else if(!data.equals(".") && !data.isBlank()) {
                stack.push(data);
            }
        }

        if(stack.isEmpty())
            return "/";

        StringBuilder response = new StringBuilder();
        while(!stack.isEmpty()) {
            response.insert(0, "/" + stack.pop());
        }

        return response.toString();
    }
}
