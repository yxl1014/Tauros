package yxl.demo.y2023.m6.d13;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int unequalTriplets(int[] nums) {
        //通过这一步可以判断出一共有多少个数  每个数有多少重复的
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        //然而题目并没有要求你数字是什么 只是要求他们不一样
        //那么三个数分别用 a b c 表示
        //我们通过数组的长度可以知道一共有多少个数
        //假设 a有2个   b有2个 c有2个
        //那么一共有8中分配  12代表下标  a1b1c1 a1b1c2 a1b2c1 a1b2c2 a2b1c1 a2b1c2 a2b2c1 a2b2c2
        //a的数量从0开始  我们遍历整理好的map 就是b  c就用n-a-b
        int ans = 0, a = 0;
        int n = nums.length;
        for (int b : cnt.values()) {
            int c = n - a - b;
            ans += a * b * c;
            a += b;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().unequalTriplets(new int[]{4, 4, 2, 4, 3});
    }

}
