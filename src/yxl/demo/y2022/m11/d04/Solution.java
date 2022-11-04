package yxl.demo.y2022.m11.d04;

/**
 * @author yxl
 * @date 2022/11/4 下午2:05
 */

class Solution {
    /**
     * 作者：宫水三叶
     * 链接：https://leetcode.cn/problems/reach-a-number/solutions/1947419/by-ac_oier-o4ze/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int reachNumber(int target) {
        if (target < 0) target = -target;
        int k = (int) Math.sqrt(2 * target), dist = k * (k + 1) / 2;
        while (dist < target || (dist - target) % 2 == 1) {
            k++;
            dist = k * (k + 1) / 2;
        }
        return k;
    }

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/reach-a-number/solutions/1946020/dao-da-zhong-dian-shu-zi-by-leetcode-sol-ak90/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int reachNumber_V2(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

}

