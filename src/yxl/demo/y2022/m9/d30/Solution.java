package yxl.demo.y2022.m9.d30;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxl
 * @date: 2022/9/30 上午9:54
 * 执行结果：通过
 * 执行用时：1 ms, 在所有 Java 提交中击败了43.70%的用户
 * 内存消耗：43.1 MB, 在所有 Java 提交中击败了38.05%的用户
 * 通过测试用例：159 / 159
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int[] ints : list) {
            int x = ints[0];
            int y = ints[1];
            for (int i = 0; i < m; i++) {
                matrix[i][y] = 0;
            }
            for (int j = 0; j < n; j++) {
                matrix[x][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
        new Solution().setZeroes(ints);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
