package yxl.demo.y2023.m3.d16;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2023/3/16 下午4:53
 */
public class Solution {
    public int countSubarrays(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length, m = (r + l) / 2;
        while (nums[m] != k) {
            if (nums[m] > k) {
                r = m;
            } else {
                l = m;
            }
            m = (l + r) / 2;
        }
        int res = Math.min(m, nums.length - m);
        if (m == 0 && nums.length > 1) {
            return 2;
        }
        if (m == nums.length - 1) {
            return 1;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[]{2, 5, 1, 4, 3, 6}, 1));
    }

    /**
     * 作者：灵茶山艾府
     * 链接：https://leetcode.cn/problems/count-subarrays-with-median-k/solutions/1993439/deng-jie-zhuan-huan-pythonjavacgo-by-end-5w11/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countSubarrays_V1(int[] nums, int k) {
        int pos = 0, n = nums.length;
        while (nums[pos] != k) {
            ++pos;
        }

        int[] cnt = new int[n * 2];
        cnt[n] = 1;
        for (int i = pos - 1, x = n; i >= 0; --i) { // 从 pos-1 开始累加 x
            x += nums[i] < k ? 1 : -1;
            ++cnt[x];
        }

        int ans = cnt[n] + cnt[n - 1];
        for (int i = pos + 1, x = n; i < n; ++i) { // 从 pos+1 开始累加 x
            x += nums[i] > k ? 1 : -1;
            ans += cnt[x] + cnt[x - 1];
        }
        return ans;
    }

}
