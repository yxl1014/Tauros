package yxl.demo.y2023.m6.d18.V1;

public class Solution {
    public int closedIsland(int[][] grid) {
        //首先图的边界岛屿肯定不是闭合的，所以先把边界上的所有岛屿排除掉
        int m = grid.length, n = grid[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            // 如果是第一行和最后一行，访问所有格子
            // 如果不是，只访问第一列和最后一列的格子
            int step = i == 0 || i == m - 1 ? 1 : n - 1;
            for (int j = 0; j < n; j += step) {
                dfs(grid, i, j);
            }
        }
        //现在剩下的就一定是封闭的 只要确保封闭的没问题 排干净就不会有错
        int sum = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) { // 从没有访问过的 0 出发
                    sum++; // 一定是封闭岛屿
                    dfs(grid, i, j);
                }
            }
        }
        return sum;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != 0) {
            return;
        }
        grid[x][y] = 1;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
