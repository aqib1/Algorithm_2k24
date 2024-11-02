package org.algorithms.io.amazon2k24;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * We're going to make our own Contacts application! The application must perform two types of operations:
 * add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
 * find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
 * Given  sequential add and find operations, perform each operation in order.
 * Example
 * Operations are requested as follows:
 * add ed
 * add eddie
 * add edward
 * find ed
 * add edwina
 * find edw
 * find a
 * Three  operations include the names 'ed', 'eddie', and 'edward'. Next,  matches all  names. Note that it matches and counts the entire name 'ed'. Next, add 'edwina' and then find 'edw'.   names match: 'edward' and 'edwina'. In the final operation, there are  names that start with 'a'. Return the array .
 * Function Description
 * Complete the contacts function below.
 * contacts has the following parameters:
 * string queries[n]: the operations to perform
 * Returns
 * int[]: the results of each find operation
 * Input Format
 * The first line contains a single integer, , the number of operations to perform (the size of ).
 * Each of the following  lines contains a string, .
 * Constraints
 *
 *
 *
 *  and  contain lowercase English letters only.
 * The input does not have any duplicate  for the  operation.
 * Sample Input
 * STDIN           Function
 * -----           --------
 * 4               queries[] size n = 4
 * add hack        queries = ['add hack', 'add hackerrank', 'find hac', 'find hak']
 * add hackerrank
 * find hac
 * find hak
 * Sample Output
 * 2
 * 0
 * Explanation
 * Add a contact named hack.
 * Add a contact named hackerrank.
 * Find the number of contact names beginning with hac. Both name start with hac, add  to the return array.
 * Find the number of contact names beginning with hak. neither name starts with hak, add  to the return array.
 *
 *
 * */


// Time and space is O(m) where m is number of characters of string

public class ContactAmazon {
    public static void main(String[] args) {
        System.out.println(
                contacts(List.of(
                                List.of("add", "hack"),
                                List.of("add", "hackerrank"),
                                List.of("find", "hac"),
                                List.of("find", "hak")
                        )
                ));
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        Trie trie = new Trie();
        var response = new ArrayList<Integer>();
        for(var query: queries) {
            if(query.get(0).equals("add")) {
                trie.insert(query.get(1));
            } else {
                response.add(trie.searchSubString(query.get(1)));
            }
        }

        return response;
    }
}
