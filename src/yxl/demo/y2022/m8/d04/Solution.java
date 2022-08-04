package yxl.demo.y2022.m8.d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yxl
 * @Date: 2022/8/4 15:42
 */
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        int curr = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            curr += nums[i];
            ans.add(nums[i]);
            if (total - curr < curr) {
                break;
            }
        }
        return ans;
    }
}
