package yxl.demo.y2023.m6.d14;

public class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0, mx = 0, n = flips.length;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, flips[i]);
            if (mx == i + 1) {
                ans++;
            }
        }
        return ans;
    }
}
