package yxl.demo.y2022.m9.d14;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author yxl
 * @date: 2022/9/14 下午2:10
 */
public class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        int d = (int) (len * 0.05);
        double r = 0;
        for (int i = d; i < len - d; i++) {
            r += arr[i];
        }

        return r / (len - 2 * d);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trimMean(new int[]{}));
    }
}
