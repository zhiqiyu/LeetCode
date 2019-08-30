/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        
        HashMap<Integer, Character> hash = new HashMap<Integer, Character>();
        
        for (int i = 0; i < intervals.length; i++) {
            if (hash.containsKey(intervals[i][0]) && hash.get(intervals[i][0]) == 'e') {
                hash.remove(intervals[i][0]);
                continue;
            }
            hash.put(intervals[i][0], 's');
            hash.put(intervals[i][1], 'e');
        }
        
        Object[] keys = hash.keySet().toArray();
        Arrays.sort(keys);
        
        boolean started = true;
        int start = (int) keys[0];
        int numStart = 0;
        for (int j = 1; j < keys.length; j++) {
            char symbol = hash.get(keys[j]);
            if (symbol == 's') {
                if (numStart == 0) start = (int) keys[j];
                numStart++;
                continue;
            }
            else {
                if (--numStart != 0) continue;
                else res.add(new int[]{start, (int) keys[j]});
            }
        }
        
        // convert list to array
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(0)[0];
            ans[i][1] = res.get(0)[1];
        }
        
        return ans;
    }
}

