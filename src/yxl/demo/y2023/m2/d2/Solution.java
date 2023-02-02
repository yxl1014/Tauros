package yxl.demo.y2023.m2.d2;

import java.util.*;

/**
 * @author yxl
 * @date 2023/2/2 下午6:37
 */
public class Solution {
    /**
     * 作者：ylb
     * 链接：https://leetcode.cn/problems/shortest-path-with-alternating-colors/solutions/2087881/python3javacgo-yi-ti-yi-jie-bfsqing-xi-t-ag0i/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] g = new List[2][n];
        for (List<Integer>[] f : g) {
            Arrays.setAll(f, k -> new ArrayList<>());
        }
        for (int[] e : redEdges) {
            g[0][e[0]].add(e[1]);
        }
        for (int[] e : blueEdges) {
            g[1][e[0]].add(e[1]);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        boolean[][] vis = new boolean[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int d = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; --k) {
                int[] p = q.poll();
                int i = p[0], c = p[1];
                if (ans[i] == -1) {
                    ans[i] = d;
                }
                vis[i][c] = true;
                c ^= 1;
                for (int j : g[c][i]) {
                    if (!vis[j][c]) {
                        q.offer(new int[]{j, c});
                    }
                }
            }
            ++d;
        }
        return ans;
    }
}
