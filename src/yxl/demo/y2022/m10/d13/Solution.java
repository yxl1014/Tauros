package yxl.demo.y2022.m10.d13;

/**
 * @author yxl
 * @date: 2022/10/13 下午3:42
 * 作者：AC_OIer
 *     链接：https://leetcode.cn/problems/max-chunks-to-make-sorted/solution/by-ac_oier-4uny/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 0;
        for (int i = 0, j = 0, min = n, max = -1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (j == min && i == max) {
                ans++; j = i + 1; min = n; max = -1;
            }
        }
        return ans;
    }
}
