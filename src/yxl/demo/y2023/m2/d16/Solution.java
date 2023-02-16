package yxl.demo.y2023.m2.d16;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2023/2/16 下午3:00
 */
public class Solution {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[l] != nums[i]) {
                int t = i - l;
                res[0] += t / 2;
                res[1] += t % 2;
                l = i;
            }
        }
        int t = nums.length - l;
        res[0] += t / 2;
        res[1] += t % 2;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().numberOfPairs(new int[]{0})));
    }
}
