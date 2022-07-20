package yxl.demo.y2022.m7.d20;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yxl
 * @Date: 2022/7/20 9:51
 */
public class Solution {
    //思路对了 无敌
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        int i = k % n != 0 ? m - 1 - k / n : m - k / n;
        int j = k % n != 0 ? n - k % n : 0;

        int num = m * n;
        int x = 0;

        List<Integer> integers = null;
        while (x < num) {
            if (x % n == 0) {
                integers = new ArrayList<>();
                list.add(integers);
            }
            integers.add(grid[i][j]);
            j++;
            if (j >= n) {
                j = 0;
                i++;
            }
            if (i >= m)
                i = 0;
            x++;
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().shiftGrid(new int[][]{{1}}/*{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}*/, 100);
        for (List<Integer> i : lists) {
            for (Integer ii : i) {
                System.out.print(ii + " ");
            }
            System.out.println();
        }
    }



    /*

    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/shift-2d-grid/solution/er-wei-wang-ge-qian-yi-by-leetcode-solut-ploz/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    * */
    public List<List<Integer>> shiftGrid_V2(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ret.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index1 = (i * n + j + k) % (m * n);
                ret.get(index1 / n).set(index1 % n, grid[i][j]);
            }
        }
        return ret;
    }
}
