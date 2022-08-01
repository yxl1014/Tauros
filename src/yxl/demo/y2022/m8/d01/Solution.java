package yxl.demo.y2022.m8.d01;

/**
 * @Author: yxl
 * @Date: 2022/8/1 10:39
 */
public class Solution {
    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++)
            stringBuilder.append("a");
        if (n % 2 == 0)
            stringBuilder.replace(n - 1, n, "b");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTheString(5));
        System.out.println(new Solution().generateTheString(4));
    }
}
