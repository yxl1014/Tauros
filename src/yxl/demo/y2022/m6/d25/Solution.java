package yxl.demo.y2022.m6.d25;

import java.util.Arrays;


/**
 *
 *     作者：LeetCode-Solution
 *     链接：https://leetcode.cn/problems/JEj789/solution/fen-shua-fang-zi-by-leetcode-solution-q0kh/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class Solution {
    public int minCost_mySelf(int[][] costs) {
        int r = 0;
        int c = 3;
        int min;
        int lastCost = -1;
        for (int[] cost : costs) {
            min=Integer.MAX_VALUE;
            for (int j = 0; j < c; j++) {
                if (min >= cost[j] && lastCost != j) {
                    min = cost[j];
                    lastCost = j;
                }
            }
            r += min;
        }
        return r;
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        //初始为各个颜色的三种情况
        int[] dp = new int[3];
        //初始化dp
        for (int j = 0; j < 3; j++) {
            dp[j] = costs[0][j];
        }
        //从第二个屋子开始
        for (int i = 1; i < n; i++) {
            //创建一个新的数据
            int[] dpNew = new int[3];
            //三种颜色
            for (int j = 0; j < 3; j++) {
                //上个地方是j颜色的地方取另外两个中较小的那个并加上原来的成本
                dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
            }
            //更新价值表
            dp = dpNew;
        }
        //取这个表中最小的那个
        return Arrays.stream(dp).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCost(new int[][]{{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}}));
    }
}
