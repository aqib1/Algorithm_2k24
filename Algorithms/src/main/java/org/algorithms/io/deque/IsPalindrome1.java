package org.algorithms.io.deque;

class CharDeque {
    private Character[] data;
    private int head;
    private int tail;
    private int size;

    public CharDeque(int len) {
        data = new Character[len];
    }

    // O(1)
    public void add(char d) {
        addLast(d);
    }

    // O(1)
    public void addFirst(char d) {
        if (isFull()) {
            throw new IllegalArgumentException("Deque is full");
        }
        final Character[] element = data;
        element[head = dec(head, element.length)] = d;
        size++;
    }

    // time complexity O(1)
    public void addLast(char d) {
        if (isFull()) {
            throw new IllegalArgumentException("Deque is full");
        }
        final Character[] element = data;
        element[tail] = d;
        tail = inc(tail, element.length);
        size++;
    }

    // O(1)
    public Character removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }
        final Character[] element = data;
        final Character d = element[head];
        if (d != null) {
            element[head] = null;
            head = inc(head, element.length);
            size--;
        }
        return d;
    }

    // O(1)
    public Character removeLast() {
        final Character[] element = data;
        final int i = dec(tail, element.length);
        final Character d = element[i];
        if (d != null) {
            element[i] = null;
            tail = i;
            size--;
        }
        return d;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    // O(1)
    private int inc(int i, int limit) {
        if (++i >= limit)
            i = 0;    // round - about
        return i;
    }

    // O(1)
    private int dec(int i, int limit) {
        if (--i < 0) i = limit - 1; // round - about
        return i;
    }
}

public class IsPalindrome1 {
    public static void main(String[] args) {
        var palindrome = new IsPalindrome1();
        System.out.println(
                palindrome.isPalindrome("ab_a")
        );
    }

    // O(n)
    public boolean isPalindrome(String s) {
        s = constructString(s);
        var deque = new CharDeque(s.length());
        // O(n)
        for (char c : s.toCharArray()) {
            deque.addLast(c);
        }

        // O(n/2)
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) return false;
        }

        return true;
    }

    // O(n)
    private String constructString(String s) {
        s = s.toLowerCase();
        String[] words = s.split(" ");
        var build = new StringBuilder();

        for (var word : words) {
            build.append(
                    word.replaceAll(
                            "[^a-zA-Z0-9]",
                            ""
                    ).trim()
            );
        }

        return build.toString();
    }
}
