package yxl.demo.y2023.m1.d19;

import java.util.ArrayList;

/**
 * @author yxl
 * @date 2023/1/19 下午1:32
 */
public class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean flag1, flag2, flag3, flag4;
        flag1 = flag2 = flag3 = flag4 = false;

        ArrayList<Character> chars = new ArrayList<>();
        chars.add('!');
        chars.add('@');
        chars.add('#');
        chars.add('$');
        chars.add('%');
        chars.add('^');
        chars.add('&');
        chars.add('*');
        chars.add('(');
        chars.add(')');
        chars.add('-');
        chars.add('+');

        if (password.length() < 8)
            return false;

        char t = ' ';
        for (char c : password.toCharArray()) {
            if (c == t)
                return false;
            else
                t = c;

            if (Character.isLowerCase(c)) {
                flag1 = true;
                continue;
            }

            if (Character.isUpperCase(c)) {
                flag2 = true;
                continue;
            }
            if (Character.isDigit(c)) {
                flag3 = true;
                continue;
            }
            if (chars.contains(c))
                flag4 = true;
        }

        return flag1 && flag2 && flag3 && flag4;
    }
}
