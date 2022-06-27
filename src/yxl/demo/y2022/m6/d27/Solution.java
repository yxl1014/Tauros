package yxl.demo.y2022.m6.d27;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/longest-uncommon-subsequence-ii/solution/zui-chang-te-shu-xu-lie-ii-by-leetcode-s-bo2e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length(); //若执行到最后说明不是独有子串
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength(new String[]{"aba", "cdc", "eae"}));
    }
}
