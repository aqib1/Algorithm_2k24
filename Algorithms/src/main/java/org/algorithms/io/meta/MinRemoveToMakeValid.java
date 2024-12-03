package org.algorithms.io.meta;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        var min = new MinRemoveToMakeValid();
        System.out.println(
                min.minRemoveToMakeValid(
                        "))(("
                )
        );
    }
    public String minRemoveToMakeValid(String s) {
        int paramCount = 0;
        var response = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                paramCount++;
            } else if(s.charAt(i) == ')') {
                paramCount--;
            }

            if(paramCount < 0) {
                paramCount = 0;
            } else {
                response.append(s.charAt(i));
            }
        }

        paramCount = 0;
        for(int i = response.length() - 1; i >= 0; i--) {
            if(response.charAt(i) == ')') {
                paramCount++;
            } else if(response.charAt(i) == '(') {
                paramCount--;
            }

            if(paramCount < 0) {
                paramCount = 0;
                response.deleteCharAt(i);
            }
        }
        return response.toString();
    }
}
