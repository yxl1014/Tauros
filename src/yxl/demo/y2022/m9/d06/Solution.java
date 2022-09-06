package yxl.demo.y2022.m9.d06;

import java.util.*;

public class Solution {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;


        ////三叶大佬杀我
        /*char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        int[] l = new int[n], r = new int[n];
        int[] cnts = new int[26];
        Arrays.fill(cnts, -1);
        for (int i = 0; i < n; i++) {
            int u = cs[i] - 'A';
            l[i] = cnts[u];
            cnts[u] = i;
        }
        Arrays.fill(cnts, n);
        for (int i = n - 1; i >= 0; i--) {
            int u = cs[i] - 'A';
            r[i] = cnts[u];
            cnts[u] = i;
        }
        for (int i = 0; i < n; i++) ans += (i - l[i]) * (r[i] - i);
        return ans;

        作者：AC_OIer
        链接：https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/solution/by-ac_oier-922k/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    }
}
