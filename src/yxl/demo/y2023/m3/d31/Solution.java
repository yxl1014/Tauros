package yxl.demo.y2023.m3.d31;

import java.util.HashMap;

/**
 * @author yxl
 * @date 2023/3/31 上午9:13
 */
public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] - nums[i] == diff) {
                    for (int k = j + 1; k < len; k++) {
                        if (nums[k] - nums[j] == diff) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }

    public int arithmeticTriplets_v2(int[] nums, int diff) {
        int res = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, true);
        }
        for (int n : nums) {
            if (map.getOrDefault(n + diff, false) && map.getOrDefault(n + 2 * diff, false)) {
                res++;
            }
        }

        return res;
    }
}
