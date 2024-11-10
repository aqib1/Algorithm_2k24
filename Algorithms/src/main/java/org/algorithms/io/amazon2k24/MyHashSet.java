class MyHashSet {
    private final static int MAX_LIMIT = (int)Math.pow(10, 6) + 1;
    private final int set[];
    public MyHashSet() {
        this.set = new int[MAX_LIMIT];
        Arrays.fill(set, -1);
    }
    
    public void add(int key) {
        this.set[key] = key;
    }
    
    public void remove(int key) {
        this.set[key] = -1;
    }
    
    public boolean contains(int key) {
        return this.set[key] != -1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
