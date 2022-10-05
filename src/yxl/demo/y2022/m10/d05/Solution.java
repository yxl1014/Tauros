package yxl.demo.y2022.m10.d05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yxl
 * @date: 2022/10/5 下午3:13
 */
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> maps = new HashMap<>();
        for (String s : cpdomains) {
            String[] ss = s.split(" ");
            String[] sss = spliteString(ss[1]);
            for (String sz : sss) {
                if (maps.containsKey(sz)) {
                    maps.put(sz, maps.get(sz) + Integer.parseInt(ss[0]));
                } else {
                    maps.put(sz, Integer.parseInt(ss[0]));
                }
            }
        }
        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    private String[] spliteString(String s) {
        String[] ss = s.split("\\.");
        String[] sss = new String[ss.length];
        int len = ss.length;
        StringBuilder temp = new StringBuilder();
        temp.append(ss[len - 1]);
        int index = 0;
        sss[index++] = temp.toString();
        for (int i = len - 2; i >= 0; i--) {
            temp.insert(0, ss[i] + ".");
            sss[index++] = temp.toString();
        }
        return sss;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subdomainVisits(new String[]{"9001 discuss.leetcode.com"}).toString());
    }
}
