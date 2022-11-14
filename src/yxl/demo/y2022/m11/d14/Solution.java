package yxl.demo.y2022.m11.d14;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yxl
 * @date 2022/11/14 上午9:51
 */
public class Solution {
    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/split-array-with-same-average/solutions/1966163/shu-zu-de-jun-zhi-fen-ge-by-leetcode-sol-f630/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length, m = n / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        boolean isPossible = false;
        for (int i = 1; i <= m; i++) {
            if (sum * i % n == 0) {
                isPossible = true;
                break;
            }
        }
        if (!isPossible) {
            return false;
        }
        Set<Integer>[] dp = new Set[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = new HashSet<Integer>();
        }
        dp[0].add(0);
        for (int num : nums) {
            for (int i = m; i >= 1; i--) {
                for (int x : dp[i - 1]) {
                    int curr = x + num;
                    if (curr * n == sum * i) {
                        return true;
                    }
                    dp[i].add(curr);
                }
            }
        }
        return false;
    }

}
