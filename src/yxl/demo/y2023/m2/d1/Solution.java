package yxl.demo.y2023.m2.d1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yxl
 * @date 2023/2/1 下午5:11
 */
public class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> keys = new HashMap<>();
        int i = 0;
        int j = 97;
        for (char c : key.toCharArray()) {
            if (c == ' ' || keys.containsKey(c)) {
                continue;
            }
            keys.put(c, (char) j++);
        }
        String res = "";
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                res += " ";
                continue;
            }
            res += keys.get(c);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }
}
