package yxl.demo.y2022.m10.d11;

import java.util.Arrays;

/**
 * @author yxl
 * @date: 2022/10/11 上午8:59
 * 执行用时：0 ms,在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.9 MB,在所有 Java 提交中击败了28.75%的用户
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] index = new int[c1.length];
        int i = 0;
        for (int x = 0; x < c1.length; x++) {
            if (c1[x] != c2[x])
                index[i++] = x;
        }
        if (i > 2 || i == 1)
            return false;
        if (i == 0)
            return true;
        char t = c1[index[0]];
        c1[index[0]] = c1[index[1]];
        c1[index[1]] = t;
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().areAlmostEqual("abcd", "dcba"));
    }
}
