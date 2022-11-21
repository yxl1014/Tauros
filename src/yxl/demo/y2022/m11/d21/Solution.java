package yxl.demo.y2022.m11.d21;

/**
 * @author yxl
 * @date 2022/11/21 下午5:40
 */
public class Solution {
    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/soup-servings/solutions/1981704/fen-tang-by-leetcode-solution-0yxs/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] +
                        dp[Math.max(0, i - 3)][Math.max(0, j - 1)] +
                        dp[Math.max(0, i - 2)][Math.max(0, j - 2)] +
                        dp[Math.max(0, i - 1)][Math.max(0, j - 3)])
                        / 4.0;
            }
        }
        return dp[n][n];
    }

}
