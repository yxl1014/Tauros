package yxl.demo.y2022.m9.d16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*
    作者：AC_OIer
    链接：https://leetcode.cn/problems/rectangle-area-ii/solution/gong-shui-san-xie-by-ac_oier-9r36/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    int MOD = (int)1e9+7;
    public int rectangleArea(int[][] rs) {
        List<Integer> list = new ArrayList<>();
        for (int[] info : rs) {
            list.add(info[0]); list.add(info[2]);
        }
        Collections.sort(list);
        long ans = 0;
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1), b = list.get(i), len = b - a;
            if (len == 0) continue;
            List<int[]> lines = new ArrayList<>();
            for (int[] info : rs) {
                if (info[0] <= a && b <= info[2]) lines.add(new int[]{info[1], info[3]});
            }
            Collections.sort(lines, (l1, l2)->{
                return l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1];
            });
            long tot = 0, l = -1, r = -1;
            for (int[] cur : lines) {
                if (cur[0] > r) {
                    tot += r - l;
                    l = cur[0]; r = cur[1];
                } else if (cur[1] > r) {
                    r = cur[1];
                }
            }
            tot += r - l;
            ans += tot * len;
            ans %= MOD;
        }
        return (int) ans;
    }

}
