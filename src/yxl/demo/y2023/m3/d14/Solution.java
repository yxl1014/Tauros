package yxl.demo.y2023.m3.d14;

import java.util.Arrays;

/**
 * @author yxl
 * @date 2023/3/14 上午9:32
 */
public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                res[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().restoreMatrix_V1(new int[]{5, 7, 10}, new int[]{8, 6, 8})));
    }

    public int[][] restoreMatrix_V1(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        int i = 0, j = 0;
        while (i < rowSum.length && j < colSum.length) {
            if (rowSum[i] < colSum[j]) {
                res[i][j] = rowSum[i];
                colSum[j] -= rowSum[i];
                i++;
            } else {
                res[i][j] = colSum[j];
                rowSum[i] -= colSum[j];
                j++;
            }
        }
        return res;
    }
}
