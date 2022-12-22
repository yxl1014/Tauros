package yxl.demo.y2022.m12.d21;

/**
 * @author yxl
 * @date 2022/12/21 下午8:47
 */
public class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int maxVal = Math.max(Math.max(a, b), c);
        return Math.min(sum - maxVal, sum / 2);
    }
}
