package yxl.demo.y2022.m7.d10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: yxl
 * @Date: 2022/7/10 9:21
 */
public class Solution {
    private Stack<int[]> queue = new Stack<>();

    public int cherryPickup(int[][] grid) {
        int i = 0, j = 0, k = 0;
        boolean flag = false;
        boolean dr = false;
        int x = grid.length;
        int y = grid[0].length;

        while (i < x && j < y && i >= 0 && j >= 0) {
            if (grid[i][j] == -1) {
                if (queue.size() == 0)
                    break;

                int[] pop = queue.pop();
                i = pop[0];
                j = pop[1];
                k = pop[2];
                dr = true;
                continue;
            } else if (grid[i][j] == 1) {
                grid[i][j] = 0;
                k++;
            }
            if (!dr) {
                if (!flag) {
                    if (i == x - 1 && j == y - 1) {
                        queue.clear();
                        queue.push(new int[]{i, j, k});
                        flag = true;
                        continue;
                    }
                    if (i + 1 < x) {
                        queue.push(new int[]{i, j, k});
                        i++;
                    } else if (j + 1 < y) {
                        queue.push(new int[]{i, j, k});
                        j++;
                    } else {
                        break;
                    }
                } else {
                    if (i == 0 && j == 0) {
                        break;
                    }
                    if (i - 1 >= 0) {
                        queue.push(new int[]{i, j, k});
                        i--;
                    } else if (j - 1 >= 0) {
                        queue.push(new int[]{i, j, k});
                        j--;
                    } else {
                        break;
                    }
                }
            } else {
                dr = false;
                if (!flag) {
                    if (i == x - 1 && j == y - 1) {
                        queue.clear();
                        //queue.push(new int[]{i, j, k});
                        flag = true;
                        continue;
                    }
                    if (j + 1 < y) {
                        //queue.push(new int[]{i, j, k});
                        j++;
                    } else if (i + 1 < x) {
                        //queue.push(new int[]{i, j, k});
                        i++;
                    } else {
                        break;
                    }
                } else {
                    if (i == 0 && j == 0) {
                        break;
                    }
                    if (j - 1 >= 0) {
                        //queue.push(new int[]{i, j, k});
                        j--;
                    } else if (i - 1 >= 0) {
                        //queue.push(new int[]{i, j, k});
                        i--;
                    } else {
                        break;
                    }
                }
            }
        }

        if (!flag || i != 0 && j != 0) {
            k = 0;
        }

        return k;
    }

    /*
    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/cherry-pickup/solution/zhai-ying-tao-by-leetcode-solution-1h3k/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int cherryPickup_V2(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[n * 2 - 1][n][n];
        for (int i = 0; i < n * 2 - 1; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(f[i][j], Integer.MIN_VALUE);
            }
        }
        f[0][0][0] = grid[0][0];
        for (int k = 1; k < n * 2 - 1; ++k) {
            for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); ++x1) {
                int y1 = k - x1;
                if (grid[x1][y1] == -1) {
                    continue;
                }
                for (int x2 = x1; x2 <= Math.min(k, n - 1); ++x2) {
                    int y2 = k - x2;
                    if (grid[x2][y2] == -1) {
                        continue;
                    }
                    int res = f[k - 1][x1][x2]; // 都往右
                    if (x1 > 0) {
                        res = Math.max(res, f[k - 1][x1 - 1][x2]); // 往下，往右
                    }
                    if (x2 > 0) {
                        res = Math.max(res, f[k - 1][x1][x2 - 1]); // 往右，往下
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, f[k - 1][x1 - 1][x2 - 1]); // 都往下
                    }
                    res += grid[x1][y1];
                    if (x2 != x1) { // 避免重复摘同一个樱桃
                        res += grid[x2][y2];
                    }
                    f[k][x1][x2] = res;
                }
            }
        }
        return Math.max(f[n * 2 - 2][n - 1][n - 1], 0);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}));

    }
}
