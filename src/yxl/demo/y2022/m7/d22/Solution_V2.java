package yxl.demo.y2022.m7.d22;

import java.util.Arrays;

/**
 * @Author: yxl
 * @Date: 2022/7/22 10:31
 * mang-guo-88
 *     芒果
 */
public class Solution_V2 {
    public int intersectionSizeTwo(int[][] intervals) {
        // 首先排序, 按右端点来(看了标签的排序和贪心, 以及读了下评论...有点作弊了)
        Arrays.sort(intervals, (o1, o2) -> o1[1] > o2[1] ? 1 : (o1[1] == o2[1] ? (Integer.compare(o1[0], o2[0])) : -1));
        // 先选择左边的最大数
        int result = 2;
        int v1 = intervals[0][1] - 1;
        int v2 = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (v2 < intervals[i][0]) {
                // 如果前一个区间的最大值不在后一个区间内, 那么我贪心的选取后一个区间的两个最大值
                // ..v1..v2..cur1..cur2..
                v1 = intervals[i][1] - 1;
                v2 = intervals[i][1];
                result += 2;
            } else if (v1 < intervals[i][0] && intervals[i][0] <= v2) {
                // 此时继续贪心选取当前区间最大值, 同时需要加入一个值到结果中
                // ..v1..cur1..v2..cur2..
                if (v2 < intervals[i][1]) {
                    v1 = v2;
                    v2 = intervals[i][1];
                } else {
                    // 如果v2和当前区间右边界一样, 则只需要更新v1
                    v1 = intervals[i][1] - 1;
                }
                result++;
            }
            // 当v1>=intervals[i][0]时候, 此时v1和v2必定再当前区间内(排序后当前区间的右边界大于等于v2), 因此不需要选
            // ..cur1..v1..v2..cur2..  不需要担心这种情况下为什么不选后面
        }
        return result;
    }

}
