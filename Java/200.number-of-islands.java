/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int res = 0;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    helper(grid, i, j, rows, cols, visited);
                    res++;
                }
                else continue;
            }
        }
        return res;
    }

    private void helper(char[][] grid, int cr, int cc, int max_r, int max_c, boolean[][] visited) {
        if (cr < 0 || cr >= max_r || cc < 0 || cc >= max_c) return;
        if (grid[cr][cc] == '0') return;
        else {
            if (visited[cr][cc]) return;
            visited[cr][cc] = true;
            helper(grid, cr-1, cc, max_r, max_c, visited);
            helper(grid, cr, cc-1, max_r, max_c, visited);
            helper(grid, cr, cc+1, max_r, max_c, visited);
            helper(grid, cr+1, cc, max_r, max_c, visited);
        }
        return;
    }
}

