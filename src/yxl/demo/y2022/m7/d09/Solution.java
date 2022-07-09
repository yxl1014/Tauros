package yxl.demo.y2022.m7.d09;

import java.util.*;

/**
 * @Author: yxl
 * @Date: 2022/7/9 9:22
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/solution/zui-chang-de-fei-bo-na-qi-zi-xu-lie-de-c-8trz/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int n = arr.length;
        //记录每一个值的下标
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            //斐波那契数列为 1 2 3 5 8.....
            //i为最右边的数，j为中间的数，k为最左边的数
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                //判断最后一个数减第二个数的值存不存在，若存在则获取下标
                int k = indices.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    //获得前两个数斐波那契子序列的长度+1与3做比较，取较大的给后两个数的子序列
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                //获取最大值
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}));
    }
}
