package yxl.demo.y2023.m2.d10.main;

/**
 * @author yxl
 * @date 2023/2/10 下午3:09
 */
public class Solution {
    static final int MOD = 1000000007;

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/dice-roll-simulation/solutions/2102282/zhi-tou-zi-mo-ni-by-leetcode-solution-yg0s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int dieSimulator(int n, int[] rollMax) {
        //次数
        int[][] d = new int[n + 1][6];
        //和
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                //到上限的那个点
                int pos = Math.max(i - rollMax[j] - 1, 0);
                //算出需要减去的数量
                int sub = ((sum[pos] - d[pos][j]) % MOD + MOD) % MOD;
                d[i][j] = ((sum[i - 1] - sub) % MOD + MOD) % MOD;
                if (i <= rollMax[j]) {
                    d[i][j] = (d[i][j] + 1) % MOD;
                }
                sum[i] = (sum[i] + d[i][j]) % MOD;
            }
        }
        return sum[n];
    }


}
