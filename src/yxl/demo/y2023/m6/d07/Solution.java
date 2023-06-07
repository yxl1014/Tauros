package yxl.demo.y2023.m6.d07;

import java.util.Arrays;

public class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        int n = reward1.length;
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            reward1[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(reward1);
        for (int i = 1; i <= k; i++) {
            ans += reward1[n - i];
        }
        return ans;
    }
}
