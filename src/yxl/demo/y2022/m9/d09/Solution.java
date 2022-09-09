package yxl.demo.y2022.m9.d09;

public class Solution {
    public int minOperations(String[] logs) {
        int i = 0;
        for (String l : logs) {
            if (l.equals("../")) {
                i = Math.max(0, i - 1);
            } else {
                if (!l.equals("./")) {
                    i++;
                }
            }
        }
        return i;
    }

    public int minOperations_MySelf(String[] logs) {
        int i = 0;
        for (String l : logs) {
            if (l.equals("../")) {
                i = Math.max(0, i - 1);
            } else {
                if (!l.equals("./")) {
                    i++;
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new String[]{"d1/", "../", "../", "../"}));
    }
}
