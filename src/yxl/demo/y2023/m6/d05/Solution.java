package yxl.demo.y2023.m6.d05;

import java.util.Arrays;

public class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        int len = nums.length - 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                res[index++] = nums[i];
            }
        }
        if (nums[len] != 0) {
            res[index] = nums[len];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{1,0,2,0,0,1})));
    }
}
