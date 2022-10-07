package yxl.demo.y2022.m10.d07;

import java.util.Arrays;

/**
 * @author yxl
 * @date: 2022/10/7 下午1:34
 */
public class Solution {
    //因为子序一定是连续的所以不涉及到背包问题
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int l = 0;
        //限定界限,l一定小于数组的长度
        while (l < nums.length) {
            int cursum = nums[l++];
            //一致循环直到 这个数比上一个数小位置
            while (l < nums.length && nums[l] > nums[l - 1]) {
                cursum += nums[l++];
            }
            res = Math.max(res, cursum);
        }
        return res;
    }

    //若子序不一定是连续的   背包问题 动态规划
    public int max(int[] max) {
        int len = max.length;
        int[][] dfs = new int[len][len];
        dfs[0] = max;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j - 1 >= 0 && max[j] > max[j - 1]) {
                    dfs[i][j] = Math.max(max[j] + dfs[i][j - 1], dfs[i - 1][j]);
                } else {
                    dfs[i][j] = dfs[i - 1][j];
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(dfs[i][j] + " ");
            }
            System.out.println();
        }
        int x = 0;
        for (int i = 0; i < len; i++) {
            x = Math.max(x, dfs[len - 1][i]);
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().max(new int[]{100, 10, 1}));
    }
}
