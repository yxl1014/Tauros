package yxl.demo.y2022.m12.d27;

/**
 * @author yxl
 * @date 2022/12/27 下午6:49
 */
public class Solution {
    public int minimumMoves(String s) {
        int num = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'X') {
                num++;
                i += 2;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumMoves("OOOO"));
    }
}
