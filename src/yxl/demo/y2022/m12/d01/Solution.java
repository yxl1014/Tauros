package yxl.demo.y2022.m12.d01;

/**
 * @author yxl
 * @date 2022/12/1 下午1:48
 */
public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] ps = points[i];
            if (ps[0] == x || ps[1] == y) {
                int m = Math.abs(ps[0] - x) + Math.abs(ps[1] - y);
                if (m < min) {
                    min = m;
                    res = i;
                }
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nearestValidPoint(3, 4, new int[][]{{3, 4}}));
    }
}
