package yxl.demo.y2022.m7.d28;

import java.util.*;

/**
 * @Author: yxl
 * @Date: 2022/7/28 10:18
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sort = arr.clone();
        Arrays.sort(sort);
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length, idx = 0;

        for (int i : sort) {
            if (!map.containsKey(i)) map.put(i, ++idx);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = map.get(arr[i]);
        return result;
    }
}
