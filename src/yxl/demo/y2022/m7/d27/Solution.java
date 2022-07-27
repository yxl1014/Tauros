package yxl.demo.y2022.m7.d27;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yxl
 * @Date: 2022/7/27 9:55
 *
 * 我是 fw
 * 执行用时：9 ms, 在所有 Java 提交中击败了33.65%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了9.13%的用户
 */
public class Solution {
    public static final char JIA = '+';
    public static final char JIAN = '-';

    public class Shu {
        boolean fh;
        int fz;
        int fm;
    }

    public String fractionAddition(String expression) {
        List<String> nums = new ArrayList<>();
        int x = 0;
        int i = 1, j = expression.length();
        for (; i < j; i++) {
            if ((expression.charAt(i) == JIA || expression.charAt(i) == JIAN)) {
                nums.add(expression.substring(x, i));
                x = i;
            }
        }
        nums.add(expression.substring(x, i));

        Shu shu = null;
        for (String s : nums) {
            if (shu == null) {
                shu = getShu(s);
                continue;
            }
            Shu shu1 = getShu(s);
            shu = jiSuan(shu, shu1);
        }

        return "" + (shu.fh ? "" : '-') + shu.fz + "/" + shu.fm;
    }

    private Shu jiSuan(Shu s1, Shu s2) {
        int gb = GB(s1.fm, s2.fm);
        s1.fz *= gb / s1.fm;
        s1.fm = gb;
        s2.fz *= gb / s2.fm;
        s2.fm = gb;
        Shu shu = new Shu();
        if (s1.fh == s2.fh) {
            shu.fh = s1.fh;
            shu.fz = s1.fz + s2.fz;
        } else {
            if (s1.fz > s2.fz) {
                shu.fh = s1.fh;
            } else if (s1.fz < s2.fz) {
                shu.fh = s2.fh;
            } else {
                shu.fh = true;
            }
            shu.fz = Math.abs(s1.fz - s2.fz);
        }
        shu.fm = s1.fm;
        int gy = GY(shu.fm, shu.fz);
        shu.fz /= gy;
        shu.fm /= gy;
        return shu;
    }

    private Shu getShu(String s) {
        Shu shu = new Shu();
        String[] ss = s.split("/");
        if (ss[0].charAt(0) == JIA || ss[0].charAt(0) == JIAN) {
            shu.fh = ss[0].charAt(0) == JIA;
            shu.fz = Integer.parseInt(ss[0].substring(1));
        } else {
            shu.fh = true;
            shu.fz = Integer.parseInt(ss[0]);
        }

        shu.fm = Integer.parseInt(ss[1]);
        return shu;
    }

    private int GB(int a, int b) {
        int m = a * b;
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        int c = a % b;//使用辗转相除法 算最大因数
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return m / b;
    }

    private int GY(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b == 0) {
            return a;
        }
        int c = a % b;//使用辗转相除法 算最大因数
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionAddition("1/3-1/2"));
    }
}
