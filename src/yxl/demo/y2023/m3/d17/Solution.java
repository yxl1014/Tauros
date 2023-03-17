package yxl.demo.y2023.m3.d17;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2023/3/17 上午10:46
 */
public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = 0;
            int sum = 0;
            for (int s : nums) {
                sum += s;
                if (sum > queries[i]) {
                    res[i] = x;
                    break;
                }
                x++;
            }
            res[i] = x;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().answerQueries(new int[]{2,3,4,5}, new int[]{1})));
    }
}
