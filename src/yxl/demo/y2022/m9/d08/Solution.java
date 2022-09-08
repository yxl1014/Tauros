package yxl.demo.y2022.m9.d08;

/**
 * @author yxl
 * @date: 2022/9/8 下午12:58
 */
public class Solution {

    //三叶大佬杀我
    //不会真的有人认为他美吧。。
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int t = n - k - 1;
        for (int i = 0; i < t; i++) {
            ans[i] = i + 1;
        }
        for (int i = t, a = n - k, b = n; i < n; ) {
            ans[i++] = a++;
            if (i < n) {
                ans[i++] = b--;
            }
        }
        return ans;
    }
}
