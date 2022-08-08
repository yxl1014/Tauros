package yxl.demo.y2022.m8.d08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: yxl
 * @Date: 2022/8/8 9:05
 *
作者：LeetCode-Solution
链接：https://leetcode.cn/problems/special-binary-string/solution/te-shu-de-er-jin-zhi-xu-lie-by-leetcode-sb7ry/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int cnt = 0, left = 0;
        List<String> subs = new ArrayList<String>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        Collections.sort(subs, (a, b) -> b.compareTo(a));
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }
        return ans.toString();
    }
}
