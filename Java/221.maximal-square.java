/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] largest = new int[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) largest[i][j] = 1;
                    else {
                        if (largest[i-1][j-1] == largest[i][j-1] && largest[i][j-1] == largest[i-1][j]) {
                            largest[i][j] = largest[i-1][j-1] + 1;
                        }
                        else largest[i][j] = Math.min(largest[i-1][j-1], Math.min(largest[i][j-1], largest[i-1][j])) + 1;
                    }
                }
                else largest[i][j] = 0;
                if (largest[i][j] > res) res = largest[i][j];
            }
        }
        return res * res;
    }
}   
// @lc code=end

