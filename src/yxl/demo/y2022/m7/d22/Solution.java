package yxl.demo.y2022.m7.d22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: yxl
 * @Date: 2022/7/22 9:37
作者：LeetCode-Solution
链接：https://leetcode.cn/problems/set-intersection-size-at-least-two/solution/she-zhi-jiao-ji-da-xiao-zhi-shao-wei-2-b-vuiv/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
        int m = 2;
        //对数组排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        List<Integer>[] temp = new List[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new ArrayList<Integer>();
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = temp[i].size(); k < m; j++, k++) {
                res++;
                help(intervals, temp, i - 1, j);
            }
        }
        return res;
    }

    public void help(int[][] intervals, List<Integer>[] temp, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) {
                break;
            }
            temp[i].add(num);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
    }

}
