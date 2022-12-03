package yxl.demo.y2022.m12.d03;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2022/12/3 下午3:26
 */
public class Solution {

    //TODO  为什么这个第二小的是0？？？   "ck077"
    public int secondHighest(String s) {
        int res = -1;
        char[] c = s.toCharArray();
        char t = ' ';
        Arrays.sort(c);
        for (char cc : c) {
            if (!Character.isDigit(cc))
                continue;
            if (t == ' ')
                t = cc;
            else if (t != cc) {
                return cc - 48;
            }
        }
        return res;
    }

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/second-largest-digit-in-a-string/solutions/2001922/zi-fu-chuan-zhong-di-er-da-de-shu-zi-by-ujgwp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int secondHighest_2(String s) {
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().secondHighest("abc1111"));
    }
}
