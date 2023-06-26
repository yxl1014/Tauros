package yxl.demo.y2023.m6.d26;

public class Solution {
    public int pivotInteger(int n) {
        int sum = (1 + n) * n / 2;
        for (int i = 1; i <= n; i++) {
            int t = ((1 + i) * i / 2);
            if (t == (sum - t + i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return 考数学谁能到啊
     */
    public int pivotInteger_V2(int n) {
        int t = (n * n + n) / 2;
        int x = (int) Math.sqrt(t);
        if (x * x == t) {
            return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pivotInteger(4));
    }
}
