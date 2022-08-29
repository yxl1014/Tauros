package yxl.demo.y2022.m8.d29;

import java.util.Arrays;

/**
 * @author yxl
 */
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int mid = n;
        int[] res = new int[n * 2];

        for (int i = 0, j = 0; i < n * 2 && j < mid && mid < n * 2; i += 2) {
            res[i] = nums[j++];
            res[i + 1] = nums[mid++];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shuffle(new int[]{}, 0)));
    }
}
