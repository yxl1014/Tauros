package yxl.demo.y2023.m6.d18.V2;

public class Solution {
    private boolean flag;

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }
        //这个思路就是从里到外 如果到边界了 说明就不是封闭的
        int sum = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) { // 从没有访问过的 0 出发
                    flag = true;
                    dfs(grid, i, j);
                    if (flag) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[x].length - 1) {
            if (grid[x][y] == 0) {
                flag = false; // 到达边界
            }
            return;
        }
        if (grid[x][y] != 0) {
            return;
        }
        grid[x][y] = 1; // 标记 (x,y) 被访问，避免重复访问
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}
