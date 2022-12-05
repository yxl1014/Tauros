package yxl.demo.y2022.m12.d04;

/**
 * @author yxl
 * @date 2022/12/4 下午2:27
 */
public class Solution {
    /**
     * 作者：Tizzi
     * 链接：https://leetcode.cn/problems/closest-dessert-cost/solutions/2004785/javac-liang-chong-jie-fa-sou-suo-dong-ta-pvwf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        boolean[] dp = new boolean[target + 5];
        //这个参数是大于target的最小组合
        int ans = Integer.MAX_VALUE;
        //因为必须选一个基料，且不用加配料 所以若基料小于target将数组相同下标设置成true
        for (int x : baseCosts) { //判断只能选
            //如果大于target 与ans去最小值
            if (x > target) ans = Math.min(ans, x);
            else dp[x] = true;
        }

        //便利每种配料
        for (int x : toppingCosts) {
            //选2次
            for (int i = 0; i < 2; i++) {
                for (int j = target; j >= 0; j--) {
                    //从又开始，若当前有且再加配料大于target 则改ans
                    if (dp[j] && j + x > target) ans = Math.min(ans, j + x); //计算大于的情况
                    //判断是否大于x
                    if (j > x) dp[j] |= dp[j - x];
                }
            }
        }
        //ans-target:目前获得与target的差距
        for (int i = 0; i <= ans - target && i <= target; i++) if (dp[target - i]) return target - i;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18));
    }
}
