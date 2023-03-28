package yxl.demo.y2023.m3.d28;

/**
 * @author yxl
 * @date 2023/3/28 下午2:27
 */
public class Solution {
    /**
     * 作者：灵茶山艾府
     * 链接：https://leetcode.cn/problems/shortest-common-supersequence/solutions/2194615/cong-di-gui-dao-di-tui-jiao-ni-yi-bu-bu-auy8z/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        // f[i+1][j+1] 表示 s 的前 i 个字母和 t 的前 j 个字母的最短公共超序列的长度
        char[] s = str1.toCharArray(), t = str2.toCharArray();
        int n = s.length, m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int j = 1; j < m; ++j) {
            f[0][j] = j; // 递归边界
        }
        for (int i = 1; i < n; ++i) {
            f[i][0] = i; // 递归边界
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s[i] == t[j]) // 最短公共超序列一定包含 s[i]
                {
                    f[i + 1][j + 1] = f[i][j] + 1;
                } else // 取更短的组成答案
                {
                    f[i + 1][j + 1] = Math.min(f[i][j + 1], f[i + 1][j]) + 1;
                }
            }
        }

        int na = f[n][m];
        char[] ans = new char[na];
        for (int i = n - 1, j = m - 1, k = na - 1; ; ) {
            if (i < 0) { // s 是空串，剩余的 t 就是最短公共超序列
                System.arraycopy(t, 0, ans, 0, j + 1);
                break; // 相当于递归边界
            }
            if (j < 0) { // t 是空串，剩余的 s 就是最短公共超序列
                System.arraycopy(s, 0, ans, 0, i + 1);
                break; // 相当于递归边界
            }
            if (s[i] == t[j]) { // 公共超序列一定包含 s[i]
                ans[k--] = s[i--]; // 倒着填 ans
                --j; // 相当于继续递归 makeAns(i - 1, j - 1)
            } else if (f[i + 1][j + 1] == f[i][j + 1] + 1) {
                ans[k--] += s[i--]; // 相当于继续递归 makeAns(i - 1, j)
            } else {
                ans[k--] += t[j--]; // 相当于继续递归 makeAns(i, j - 1)
            }
        }
        return new String(ans);
    }
}
