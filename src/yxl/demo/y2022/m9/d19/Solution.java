package yxl.demo.y2022.m9.d19;

import java.util.*;

/**
 * @author yxl
 * @date: 2022/9/19 上午9:58
 */
public class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet())
            list.add(new int[]{key, map.get(key)});
        Collections.sort(list, (a, b) -> {
            return a[1] != b[1] ? a[1] - b[1] : b[0] - a[0];
        });
        int[] ans = new int[n];
        int idx = 0;
        for (int[] info : list) {
            int a = info[0], b = info[1];
            while (b-- > 0) ans[idx++] = a;
        }
        return ans;
    }
}
