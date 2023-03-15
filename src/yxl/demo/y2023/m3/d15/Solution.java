package yxl.demo.y2023.m3.d15;

import java.util.ArrayList;

/**
 * @author yxl
 * @date 2023/3/15 上午9:33
 */
public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] sum = new int[n];
        int[][] g = new int[n][n];
        for (int[] road : roads) {
            sum[road[0]] += 1;
            sum[road[1]] += 1;
            g[road[0]][road[1]] = 1;
            g[road[1]][road[0]] = 1;
        }
        int ans = 0;
        for (int a = 0; a < n; ++a) {
            for (int b = a + 1; b < n; ++b) {
                ans = Math.max(ans, sum[a] + sum[b] - g[a][b]);
            }
        }
        return ans;
    }
}
