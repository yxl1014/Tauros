package yxl.demo.y2022.m9.d27;

import java.util.Arrays;

/**
 * @author yxl
 * @date: 2022/9/27 下午2:11
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
