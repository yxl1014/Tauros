package yxl.demo.y2023.m4.d26;

import java.util.*;

/**
 * @author lei 1627419257@qq.com
 * @date 2023/4/26 下午7:22
 */
public class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        List<int[]> first = new ArrayList<>();
        List<int[]> second = new ArrayList<>();
        int l1 = nums.length - firstLen;
        for (int i = 0; i <= l1; i++) {
            first.add(new int[]{i, i + firstLen, Arrays.stream(nums, i, i + firstLen).sum()});
        }
        int l2 = nums.length - secondLen;
        for (int i = 0; i <= l2; i++) {
            second.add(new int[]{i, i + secondLen, Arrays.stream(nums, i, i + secondLen).sum()});
        }
        int max = 0;
        for (int[] is : first) {
            for (int[] js : second) {
                if (is[1] <= js[0] && is[0] <= js[1] || js[1] < is[0] && js[0] <= is[1]) {
                    max = Math.max(max, is[2] + js[2]);
                }
            }
        }
        return max;
    }


    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/solutions/2244443/liang-ge-fei-zhong-die-zi-shu-zu-de-zui-ih3n2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxSumTwoNoOverlap_V1(int[] nums, int firstLen, int secondLen) {
        return Math.max(help(nums, firstLen, secondLen), help(nums, secondLen, firstLen));
    }

    public int help(int[] nums, int firstLen, int secondLen) {
        int suml = 0;
        for (int i = 0; i < firstLen; ++i) {
            suml += nums[i];
        }
        int maxSumL = suml;
        int sumr = 0;
        for (int i = firstLen; i < firstLen + secondLen; ++i) {
            sumr += nums[i];
        }
        int res = maxSumL + sumr;
        for (int i = firstLen + secondLen, j = firstLen; i < nums.length; ++i, ++j) {
            suml += nums[j] - nums[j - firstLen];
            maxSumL = Math.max(maxSumL, suml);
            sumr += nums[i] - nums[i - secondLen];
            res = Math.max(res, maxSumL + sumr);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
        System.out.println(new Solution().maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
        System.out.println(new Solution().maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
    }
}
