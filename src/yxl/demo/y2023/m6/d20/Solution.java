package yxl.demo.y2023.m6.d20;

import java.util.List;

public class Solution {
    /**
     * 作者：灵茶山艾府
     * 链接：https://leetcode.cn/problems/minimum-cost-to-connect-two-groups-of-points/solutions/2314687/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-djxq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.get(0).size();
        int[] f = new int[1 << m];
        for (int j = 0; j < m; j++) {
            int mn = Integer.MAX_VALUE;
            for (List<Integer> c : cost) {
                mn = Math.min(mn, c.get(j));
            }
            int bit = 1 << j;
            for (int mask = 0; mask < bit; mask++) {
                f[bit | mask] = f[mask] + mn;
            }
        }
        for (List<Integer> row : cost) {
            Object[] r = row.toArray(); // 转成数组效率更高
            for (int j = (1 << m) - 1; j >= 0; j--) {
                int res = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) // 第一组的点 i 与第二组的点 k
                {
                    res = Math.min(res, f[j & ~(1 << k)] + (int) r[k]);
                }
                f[j] = res;
            }
        }
        return f[(1 << m) - 1];
    }
}
