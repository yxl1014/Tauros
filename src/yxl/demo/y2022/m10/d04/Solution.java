package yxl.demo.y2022.m10.d04;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author yxl
 * @date: 2022/10/4 上午9:12
 */
public class Solution {
    public int minAddToMakeValid(String s) {
        Queue<Character> queue1 = new ArrayDeque<>();
        Queue<Character> queue2 = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                queue1.add(c);
            }
            if (c == ')') {
                if (queue1.size() == 0) {
                    queue2.add(c);
                } else {
                    queue1.poll();
                }
            }
        }
        return queue1.size() + queue2.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minAddToMakeValid("())"));
    }
}
