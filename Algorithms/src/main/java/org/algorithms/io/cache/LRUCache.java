package org.algorithms.io.cache;

import java.util.*;

/*
* Intuition

Let’s suppose we have an LRU cache of capacity 3, and we would like to perform the following operations:

put (key=1, value=A) into the cache
put (key=2, value=B) into the cache
put (key=3, value=C) into the cache
get (key=2) from the cache
get (key=4) from the cache
put (key=4, value=D) into the cache
put (key=3, value=E) into the cache
get (key=4) from the cache
put (key=1, value=A) into the cache

Detailed Explanation of each operation:

put (key 1, value A) : Since LRU cache has empty capacity=3, there is no need for any replacement and we put {1 : A} at the top i.e. {1 : A} has highest priority.
put (key 2, value B) : Since LRU cache has empty capacity=2, again there is no need for any replacement, but now the {2 : B} has the highest priority and priority of {1 : A} decrease.
put (key 3, value C) : Still there is 1 empty space vacant in the cache, therefore put {3 : C} without any replacement, notice now the cache is full and the current order of priority from highest to lowest is {3:C}, {2:B}, {1:A}.
get (key 2) : Now, return value of key=2 during this operation, also since key=2 is used, now the new priority order is {2:B}, {3:C}, {1:A}
get (key 4): Observe that key 4 is not present in the cache, we return ‘-1’ for this operation.
put (key 4, value D) : Observe that cache is FULL, now use LRU algorithm to determine which key is least recently used. Since {1:A} had the least priority, remove {1:A} from our cache and put {4:D} into the cache. Notice that the new priority order is {4:D}, {2:B}, {3:C}
put (key 3, value E) : Since key=3 was already present in the cache having value=C, so this operation won’t result in removal of any key, rather it will update the value of key=3 to ‘ E’ . Now, the new order of priority will become {3:E}, {4:D}, {2:B}
get (key 4) : Return the value of key=4. Now, new priority will become {4:D}, {3:E}, {2:B}
put (key 1, value A) : Since our cache is FULL, so use our LRU algorithm to determine which key was least recently used, and since {2:B} had the least priority, remove {2:B} from our cache and put {1:A} into the cache. Now, the new priority order is {1:A}, {4:D}, {3:E}.

Design Detailes

The basic idea behind implementing an LRU (Least Recently Used) cache using a key-value pair approach is to manage element access and removal efficiently through a combination of a doubly linked list and a hash map.

When adding a new key-value pair, insert it as a new node at the head of the doubly linked list. This ensures that the newly added key-value pair is marked as the most recently used.
If the key is already present in the cache , get the corresponding node in the doubly linked list using hashmap , update its value and move it to the head of the list, and update its position in the hashmap also. This operation ensures that the accessed key-value pair is considered the most recently used.
The priority of nodes in the doubly linked list is based on their distance from the head . Key-value pairs closer to the head are more recently used and thus have higher priority . Also, key-value pairs closer to the tail are considered less recently used and have lower priority.
When the cache reaches its maximum capacity and a new key-value pair needs to be added, remove the node from hashmap as well as from the tail in the doubly linked list . Tail node represents the least recently used key-value pair and is removed to make space for the new entry.

Complexity

Time complexity: O(1)

Space complexity: O(N)


* 
* 
* */

public class LRUCache {
    public static void main(String[] args) {
        var cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int value = -1;
        if (cache.containsKey(key)) {
            var current = cache.get(key);
            value = current.getValue();
            removeNode(current);
            addNode(current);
        }
        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            var current = cache.get(key);
            current.setValue(value);
            removeNode(current);
            addNode(current);
        } else {
            if (cache.size() == capacity) {
                cache.remove(head.next.key);
                removeNode(head.next);
            }
            var current = new Node(value, key);
            cache.put(key, current);
            addNode(current);
        }
    }

    private void addNode(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    private void removeNode(Node node) {
        var prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    static class Node {
        private Node next;
        private Node prev;
        private int key;
        private int value;

        Node() {

        }

        Node(int value, int key) {
            this.value = value;
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
