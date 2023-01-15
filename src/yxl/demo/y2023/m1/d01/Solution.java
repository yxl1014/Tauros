package yxl.demo.y2023.m1.d01;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2023/1/15 下午3:28
 */
public class Solution {
    public int minMaxGame(int[] nums) {
        //System.out.println(Arrays.toString(nums));
        if (nums.length == 1) {
            return nums[0];
        }
        int[] newNums = new int[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMaxGame(new int[]{3}));
    }
}
