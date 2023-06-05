package yxl.demo.y2023.m6.d04;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Float> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            set.add(((float) (nums[i] + nums[j])) / 2);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().distinctAverages(new int[]{1,100}));
    }
}
