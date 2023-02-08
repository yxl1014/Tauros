package yxl.demo.y2023.m2.d8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yxl
 * @date 2023/2/8 下午7:44
 */
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        String pre = null;
        for (String s : folder) {
            if (pre == null) {
                res.add(s);
                pre = s;
                continue;
            }
            if (pre.length() >= s.length() ||
                    !(pre.equals(s.substring(0, pre.length())) && s.charAt(pre.length()) == '/')) {
                res.add(s);
                pre = s;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
    }
}
