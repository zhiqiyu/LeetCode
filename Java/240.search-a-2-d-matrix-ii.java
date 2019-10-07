/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // if (matrix[0][0] > target || matrix[rows-1][cols-1] < target) return false;
        
        return search(matrix, 0, rows-1, 0, cols-1, target);

    }

    private boolean search(int[][] matrix, int rstart, int rend, int cstart, int cend, int target) {
        if (rstart > rend || cstart > cend) return false;
        int rows = rend - rstart + 1;
        int cols = cend - cstart + 1;
        if (matrix[rstart][cstart] > target || matrix[rend][cend] < target) return false;
        int i;
        for (i = 0; i < Math.min(rows, cols); i++) {
            if (matrix[rstart + i][cstart + i] == target) return true;
            else if (matrix[rstart + i][cstart + i] > target) break;
        }

        
        return search(matrix, rstart + i, rend, cstart, cstart + i-1, target) || search(matrix, rstart, rstart + i-1, cstart + i, cend, target);
    }
}
// @lc code=end

