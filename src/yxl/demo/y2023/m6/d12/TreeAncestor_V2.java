package yxl.demo.y2023.m6.d12;

import java.util.Arrays;

public class TreeAncestor_V2 {
    static final int LOG = 16;
    private int[][] dp;

    //这个是竖着看的
    //首先先构建他的第0列  就是记录他的父节点
    //依次构建后面的列
    //比如 我现在构建第1列  先判断他的父节点是不是-1，如果是则就不需要了 ，如果不是，那么 就记录他的爷爷是什么
    //简单的来说
    //就是把所有可能性都给你想好了 动态规划
    private TreeAncestor_V2(int n, int[] parent) {
        dp = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }

        for (int j = 1; j < LOG; j++) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (dp[i][j - 1] != -1) {
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
                    flag = false;
                }
            }
            if (flag) {
                break; //都是-1就直接不用构建了
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if (((k >> j) & 1) != 0) {
                node = dp[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }

}
