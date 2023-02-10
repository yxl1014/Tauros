package yxl.demo.y2023.m2.d10;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2023/2/10 下午2:43
 */
public class Solution {
    static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n + 1][7];
        // 初始化
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                // 加入第 i-1 次得所有可能序列总数
                long ans = Arrays.stream(dp[i - 1]).sum();
                int idx = i - 1 - rollMax[j - 1];
                if (idx >= 1) {
                    // 减去 i - 1 - rollMax[j-1]次掷出1，2，3，4，5 的所有序列总数
                    ans -= Arrays.stream(dp[idx]).sum();
                    ans += dp[idx][j];
                } else if (idx == 0) {
                    // 特殊情况处理
                    ans -= 1;
                }
                dp[i][j] = (int) (ans % MOD);
            }
        }
        return Arrays.stream(dp[n]).sum() % MOD;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().dieSimulator(6, new int[]{1, 1, 2, 2, 2, 3}));
    }
}
