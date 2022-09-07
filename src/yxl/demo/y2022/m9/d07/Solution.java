package yxl.demo.y2022.m9.d07;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    执行用时：
7 ms
, 在所有 Java 提交中击败了
6.98%
的用户
内存消耗：
40.2 MB
, 在所有 Java 提交中击败了
5.08%
的用户
通过测试用例：
89 / 89
    * */
    public String reorderSpaces_MySelf(String text) {
        char[] arr = text.toCharArray();
        int index = -1;
        int kg = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                kg++;
                if (index != -1) {
                    list.add(text.substring(index, i));
                }
                index = -1;
            } else {
                if (index == -1) {
                    index = i;
                }
            }
        }
        if (index != -1) {
            list.add(text.substring(index));
        }
        int size = list.size() - 1;
        int l = kg;
        int lk = kg;
        if (size != 0) {
            l = kg / size;
            lk = kg % size;
        }
        String k = "";
        for (int i = 0; i < l; i++)
            k += " ";
        String kk = "";

        for (int i = 0; i < lk; i++)
            kk += " ";

        String res = "";
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 == list.size())
                break;
            res += list.get(i) + k;
        }
        res += list.get(size) + kk;
        return res;
    }

    //三叶大佬杀我
    public String reorderSpaces(String s) {
        int n = s.length(), cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ' && ++i >= 0 && ++cnt >= 0) continue;
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            list.add(s.substring(i, j));
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        int m = list.size(), t = cnt / Math.max(m - 1, 1);
        String k = "";
        while (t-- > 0) k += " ";
        for (int i = 0; i < m; i++) {
            sb.append(list.get(i));
            if (i != m - 1) sb.append(k);
        }
        while (sb.length() != n) sb.append(" ");
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces("a"));
    }
}
