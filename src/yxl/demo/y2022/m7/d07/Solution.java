package yxl.demo.y2022.m7.d07;

import java.util.List;

/**
 * @Author: yxl
 * @Date: 2022/7/7 11:14
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] ss = sentence.split(" ");
        for (String s : dictionary) {
            for (int i = 0; i < ss.length; i++) {
                if (ss[i].startsWith(s)) {
                    ss[i] = s;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i]);
            if (i + 1 != ss.length) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /*
@可爱抱抱呀
执行用时：5 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：52.8 MB, 在所有 Java 提交中击败了30.89%的用户
2022年7月6日 10:51
*/
    public String replaceWords_Trim(List<String> dictionary, String sentence) {
        String s[] = sentence.split(" ");
        Trie trie = new Trie();
        for (int i = 0; i < dictionary.size(); i++) {
            insert(trie, dictionary.get(i));
        }
        StringBuilder ans = new StringBuilder(findRoot(trie, s[0]));
        for (int i = 1; i < s.length; i++) {
            ans.append(" ").append(findRoot(trie, s[i]));
        }
        return ans.toString();
    }

    String findRoot(Trie trie, String s) {
        Trie t = trie;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            if (t.children[a] == null) {
                break;
            }
            if (t.children[a].hasEnd) {
                return s.substring(0, i + 1);
            }
            t = t.children[a];
        }
        return s;
    }

    void insert(Trie trie, String s) {
        Trie t = trie;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            if (t.children[a] == null) {
                t.children[a] = new Trie();
            }
            t = t.children[a];
        }
        t.hasEnd = true;
    }
}

class Trie {
    Trie children[];
    boolean hasEnd;

    public Trie() {
        hasEnd = false;
        children = new Trie[26];
    }
}
