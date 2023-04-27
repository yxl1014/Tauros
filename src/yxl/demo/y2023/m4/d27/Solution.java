package yxl.demo.y2023.m4.d27;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lei 1627419257@qq.com
 * @date 2023/4/27 下午5:48
 */
public class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> d = new HashMap<>();
        int ans = 0;
        for (String s : words) {
            int x = 0;
            for (int i = 0; i < s.length(); ++i) {
                String t = s.substring(0, i) + s.substring(i + 1);
                x = Math.max(x, d.getOrDefault(t, 0) + 1);
            }
            d.put(s, x);
            ans = Math.max(ans, x);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
