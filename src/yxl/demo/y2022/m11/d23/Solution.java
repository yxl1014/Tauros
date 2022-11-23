package yxl.demo.y2022.m11.d23;

/**
 * @author yxl
 * @date 2022/11/23 下午2:57
 */
public class Solution {
    /**
     * 作者：宫水三叶
     * 链接：https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/solutions/1986579/by-ac_oier-3mxf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        int[] cnts = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            int j = i, cur = 0;
            while (j != 0) {
                cur += j % 10;
                j /= 10;
            }
            if (++cnts[cur] > ans)
                ans = cnts[cur];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBalls(1,10));
    }

}
