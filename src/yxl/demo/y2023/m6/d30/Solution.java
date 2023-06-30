package yxl.demo.y2023.m6.d30;

public class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] ss = sentence.split(" ");
        int len = ss.length;
        if (ss[len - 1].charAt(ss[len - 1].length() - 1) != ss[0].charAt(0)) {
            return false;
        }
        for (int i = 0; i < len - 1; i++) {
            if (ss[i].charAt(ss[i].length() - 1) != ss[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isCircularSentence("Leetcode is cool"));
    }
}
