/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */
class LRUCache {

    private Map<Integer, Integer> map;
    private List<Integer> seq;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        seq = new ArrayList<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            seq.remove(0);
            seq.add(key);
            return map.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (map.size() == cap) {
            map.remove(seq.get(0));
            seq.remove(0);
            map.put(key, value);
            seq.add(key);
        }
        else {
            map.put(key, value);
            seq.add(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

