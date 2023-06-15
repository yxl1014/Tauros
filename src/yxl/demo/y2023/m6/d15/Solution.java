package yxl.demo.y2023.m6.d15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //超出时间限制
    //28 / 31 个通过的测试用例
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        HashMap<Integer, HashMap<Character, Integer>> dfs = new HashMap<>();

        int len = s.length();
        int qLen = queries.length;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < qLen; j++) {
                int[] query = queries[j];
                if (i >= query[0] && i <= query[1]) {
                    dfs.computeIfAbsent(j, k -> new HashMap<>());
                    HashMap<Character, Integer> ddd = dfs.get(j);
                    ddd.put(c, ddd.getOrDefault(c, 0) + 1);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < qLen; i++) {
            HashMap<Character, Integer> map = dfs.get(i);
            int[] query = queries[i];
            if (query[1] - query[0] + 1 == 1) {
                res.add(true);
                continue;
            }
            int js = 0;
            for (int x : map.values()) {
                if (x % 2 != 0) {
                    js++;
                }
            }
            if (js / 2 > query[2]) {
                res.add(false);
            } else {
                res.add(true);
            }
        }
        return res;
    }

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/can-make-palindrome-from-substring/solutions/2297460/gou-jian-hui-wen-chuan-jian-ce-by-leetco-e9i1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Boolean> canMakePaliQueries_V2(String s, int[][] queries) {
        int n = s.length();
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1], k = queries[i][2];
            int bits = 0, x = count[r + 1] ^ count[l];
            while (x > 0) {
                x &= x - 1;
                bits++;
            }
            res.add(bits <= k * 2 + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMakePaliQueries_V2("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}}));
    }
}
