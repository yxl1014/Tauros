package yxl.demo.y2022.m7.d12;

/**
 * @Author: yxl
 * @Date: 2022/7/12 9:52
 */
public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int res = 0;
        int[][] d = new int[m][n];
        for (int[] i : indices) {
            for (int j = 0; j < n; j++) {
                d[i[0]][j]++;
            }
            for (int j = 0; j < m; j++) {
                d[j][i[1]]++;
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (d[i][j] % 2 != 0)
                    res++;
        return res;
    }

    public int oddCells_V2(int m, int n, int[][] indices) {
        int[] mm = new int[m];
        int[] nn = new int[n];
        for (int[] i : indices) {
                mm[i[0]]++;
                nn[i[1]]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if ((mm[i]+nn[j]) % 2 != 0)
                    res++;
        return res;
    }
}
