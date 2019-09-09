/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;

        ArrayList<int[]> res = new ArrayList<>();
        
        Comparator<int[]> c = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        };

        Arrays.sort(intervals, c);
        
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp = helper(temp, intervals[i]);
            }
            else {
                res.add(temp);
                temp = intervals[i];
            }
        }
        res.add(temp);
        
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }

    private int[] helper(int[] a, int[] b) {
        return new int[] {a[0], Math.max(a[1], b[1])};
    }
}

