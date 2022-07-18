package yxl.demo.y2022.m7.d18;

import java.util.*;

/**
 * @Author: yxl==废柴
 * @Date: 2022/7/18 10:08
 */
public class Solution {
    private int res = 0;
    private int[][] wall1;//横着的墙
    private int[][] wall2;//竖着的抢

    public int containVirus_My(int[][] isInfected) {
        int x = isInfected.length;
        int y = isInfected[0].length;

        this.wall1 = new int[x - 1][y];
        this.wall2 = new int[x][y - 1];

        isInfected(isInfected);

        return res;
    }

    private boolean isInfected(int[][] isInfected) {
        for (int i = 0; i < isInfected.length; i++) {
            for (int j = 0; j < isInfected[0].length; j++) {
                if (hasWall1(isInfected, i, j) && hasWall2(isInfected, i, j))
                    continue;
                buildWall1(isInfected, i, j);
                buildWall2(isInfected, i, j);
                return true;
            }
        }
        return false;
    }

    private void buildWall1(int[][] is, int i, int j) {
        if (i < is.length - 1 && is[i + 1][j] != 1)
            wall1[i][j] = 1;
    }

    private void buildWall2(int[][] is, int i, int j) {
        if (j < is[0].length - 1 && is[i][j + 1] != 1)
            wall2[i][j] = 1;
    }


    private boolean hasWall1(int[][] is, int i, int j) {
        if (i < is.length - 1 && is[i + 1][j] != 1)
            return wall1[i][j] == 1;
        return true;
    }

    private boolean hasWall2(int[][] is, int i, int j) {
        if (j < is[0].length - 1 && is[i][j + 1] != 1)
            return wall2[i][j] == 1;
        return true;
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//----------------------------------------------------------------------------------------------------------------
    /*
    *
    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/contain-virus/solution/ge-chi-bing-du-by-leetcode-solution-vn9m/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;
        while (true) {
            List<Set<Integer>> neighbors = new ArrayList<Set<Integer>>();
            List<Integer> firewalls = new ArrayList<Integer>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1) {
                        Queue<int[]> queue = new ArrayDeque<int[]>();
                        queue.offer(new int[]{i, j});
                        Set<Integer> neighbor = new HashSet<Integer>();
                        int firewall = 0, idx = neighbors.size() + 1;
                        isInfected[i][j] = -idx;

                        while (!queue.isEmpty()) {
                            int[] arr = queue.poll();
                            int x = arr[0], y = arr[1];
                            for (int d = 0; d < 4; ++d) {
                                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 1) {
                                        queue.offer(new int[]{nx, ny});
                                        isInfected[nx][ny] = -idx;
                                    } else if (isInfected[nx][ny] == 0) {
                                        ++firewall;
                                        neighbor.add(getHash(nx, ny));
                                    }
                                }
                            }
                        }
                        neighbors.add(neighbor);
                        firewalls.add(firewall);
                    }
                }
            }

            if (neighbors.isEmpty()) {
                break;
            }

            int idx = 0;
            for (int i = 1; i < neighbors.size(); ++i) {
                if (neighbors.get(i).size() > neighbors.get(idx).size()) {
                    idx = i;
                }
            }
            ans += firewalls.get(idx);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] < 0) {
                        if (isInfected[i][j] != -idx - 1) {
                            isInfected[i][j] = 1;
                        } else {
                            isInfected[i][j] = 2;
                        }
                    }
                }
            }
            for (int i = 0; i < neighbors.size(); ++i) {
                if (i != idx) {
                    for (int val : neighbors.get(i)) {
                        int x = val >> 16, y = val & ((1 << 16) - 1);
                        isInfected[x][y] = 1;
                    }
                }
            }
            if (neighbors.size() == 1) {
                break;
            }
        }
        return ans;
    }

    public int getHash(int x, int y) {
        return (x << 16) ^ y;
    }

    //-----------------------------------------------------------------------------------------------------------
    /*
    * 作者：jiang-hui-4
    链接：https://leetcode.cn/problems/contain-virus/solution/ge-chi-bing-du-by-jiang-hui-4-21s8/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
/*    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};*/
    int curWall = 0;
    int rows;
    int cols;

    public int containVirus_V2(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int result = 0;
        while (true) {
            int walls = getMaxAreaNeedWalls(grid);
            if (walls == 0) {
                break;
            }
            result += walls;
        }
        return result;
    }

    private int getMaxAreaNeedWalls(int[][] grid) {
        //maxArea代表最大的感染区,ans代表需要修的墙的数量,
        //targetX、targetY表示此区域的DFS开始的坐标
        //state表示当前区域要修建墙的状态,如果没有修过,需要给maxArea+1,修过的话，只加墙的数量,不加maxArea
        //并且每个区域的state都是不一样的，互相不能影响 DFS完给state-1
        int maxArea = 0, ans = 0, targetX = -1, targetY = -1, state = -3;
        //用一个数组来装当前这个点的状态
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    curWall = 0;
                    int curMaxArea = dfs(grid, visited, i, j, state);
                    if (curMaxArea > maxArea) {
                        maxArea = curMaxArea;
                        ans = curWall;
                        targetX = i;
                        targetY = j;
                    }
                    state--;
                }
            }
        }
        if (targetX == -1) {
            return 0;
        }
        //将活跃的病毒改为死亡状态
        modifyDead(grid, targetX, targetY);
        visited = new int[rows][cols];
        //病毒扩散
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    spread(grid, visited, i, j);
                }
            }
        }
        return ans;
    }

    private void spread(int[][] grid, int[][] visited, int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                    && visited[newX][newY] == 0) {
                //扩散区域
                if (grid[newX][newY] == 0) {
                    grid[newX][newY] = 1;
                    visited[newX][newY] = 1;
                } else if (grid[newX][newY] == 1) {
                    spread(grid, visited, newX, newY);
                }
            }
        }
    }

    private void modifyDead(int[][] grid, int x, int y) {
        grid[x][y] = -2;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                modifyDead(grid, newX, newY);
            }
        }
    }

    private int dfs(int[][] grid, int[][] visited, int x, int y, int state) {
        int curArea = 0;
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && visited[newX][newY] != 1) {
                //不是病毒
                if (grid[newX][newY] == 0) {
                    curWall++;
                    if (visited[newX][newY] != state) {
                        curArea++;
                        visited[newX][newY] = state;
                    }
                } else if (grid[newX][newY] == 1) {
                    //是存活病毒
                    curArea += dfs(grid, visited, newX, newY, state);
                }
            }
        }
        return curArea;
    }

}
