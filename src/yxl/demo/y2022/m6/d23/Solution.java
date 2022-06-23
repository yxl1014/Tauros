package yxl.demo.y2022.m6.d23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words/solution/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-244a/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int wordSize = words.length;
        int wordLen = words[0].length();
        int sLen = s.length();
        for (int i = 0; i < wordLen; i++) {
            if (i + wordSize * wordLen > sLen) {//如果单词长度和大于s的长度，则退出
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();

            for (int j = 0; j < wordSize; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < sLen - wordSize * wordLen + 1; start += wordLen) {
                if (start != i) {
                    String word = s.substring(start + (wordSize - 1) * wordLen, start + wordSize * wordLen);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    String substring = s.substring(start - wordLen, start);
                    word = substring;
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = substring;
                }
                if (differ.isEmpty()) {
                    list.add(start);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});
    }
}
