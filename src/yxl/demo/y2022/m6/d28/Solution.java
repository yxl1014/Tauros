package yxl.demo.y2022.m6.d28;

import java.util.Arrays;

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode.cn/problems/wiggle-sort-ii/solution/bai-dong-pai-xu-ii-by-leetcode-solution-no0s/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        //x为了使交换小于半次
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            //赋值小的数
            nums[i] = arr[j];
            //赋值大的数
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }


    public static void main(String[] args) {
        new Solution().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }
}
