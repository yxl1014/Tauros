package yxl.demo.y2022.m12.d26;

import java.util.HashMap;

/**
 * @author yxl
 * @date 2022/12/26 下午7:02
 */
public class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int countHomogenous(String s) {
        int n = s.length();
        long ans = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            j = i;
            //双指针计算连续的长度
            while (j < n && s.charAt(j) == s.charAt(i)) {
                ++j;
            }
            int cnt = j - i;
            //核心： 假设 有连续n个的字符   那么  这个连续的字符串 包含 （1+n）* n / 2 个同构子字符串
            ans += (long) (1 + cnt) * cnt / 2;
            ans %= MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countHomogenous("abbcccaa"));
    }
}
