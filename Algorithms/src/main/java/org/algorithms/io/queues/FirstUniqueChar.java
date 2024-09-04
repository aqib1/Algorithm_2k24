public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        for (int i = 0; !queue.isEmpty() && i < s.length(); i++) {
            var ch = queue.poll();
            if (!queue.contains(ch)) {
                return i;
            } else {
                queue.add(ch);
            }
        }

        return -1;

    }
}
