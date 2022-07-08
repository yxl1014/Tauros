package yxl.demo.y2022.m7.d08;

/**
 * @Author: yxl
 * @Date: 2022/7/8 9:18
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/solution/wan-chou-ma-by-leetcode-solution-swnp/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    //一共三个位置，1，2，3；移动一格得代价为1，移动两格的代价为0，只有三种情况，移动到1和3上情况一样看作为一种，移动到2上
    //因为移动两格得代价为0，所以只要看是从1或3移动到2上还是2移动到1或3上，所以可以看成取奇数偶数得个数。
    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for (int pos : position) {
            if ((pos & 1) != 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }
}


