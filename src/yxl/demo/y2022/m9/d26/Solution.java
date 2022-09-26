package yxl.demo.y2022.m9.d26;

import java.util.Arrays;

/**
 * @author yxl
 * @date: 2022/9/26 上午11:10
 *
作者：AC_OIer
链接：https://leetcode.cn/problems/missing-two-lcci/solution/by-ac_oier-pgeh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, cur = n * (1 + n) / 2;
        for (int x : nums) cur -= x;
        int sum = cur, t = cur / 2;
        cur = t * (1 + t) / 2;
        for (int x : nums) {
            if (x <= t) cur -= x;
        }
        return new int[]{cur, sum - cur};
    }

}
