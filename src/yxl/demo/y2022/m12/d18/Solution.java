package yxl.demo.y2022.m12.d18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxl
 * @date 2022/12/18 下午8:19
 */
public class Solution {
    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/solutions/2024008/de-dao-lian-xu-k-ge-1-de-zui-shao-xiang-mk5ws/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int minMoves(int[] nums, int k) {
        List<Integer> g = new ArrayList<Integer>();
        List<Integer> preSum = new ArrayList<Integer>();
        preSum.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                g.add(i - g.size());
                preSum.add(preSum.get(preSum.size() - 1) + g.get(g.size() - 1));
            }
        }
        int m = g.size(), res = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; i++) {
            int mid = i + k / 2;
            int r = g.get(mid);
            res = Math.min(res, (1 - k % 2) * r + (preSum.get(i + k) - preSum.get(mid + 1)) - (preSum.get(mid) - preSum.get(i)));
        }
        return res;
    }
}
