package yxl.demo.y2022.m7.d11;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yxl
 * @Date: 2022/7/11 9:57
 *
作者：LeetCode-Solution
链接：https://leetcode.cn/problems/implement-magic-dictionary/solution/shi-xian-yi-ge-mo-fa-zi-dian-by-leetcode-b35s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MagicDictionary {
    static class Trie {
        //判断这个位置是否是一个单词
        boolean isFinished;

        //他的孩子节点们
        Trie[] child;

        public Trie() {
            isFinished = false;
            child = new Trie[26];
        }
    }

    //trie树根节点
    Trie root;

    //初始化trie数
    public MagicDictionary() {
        root = new Trie();
    }


    public void buildDict(String[] dictionary) {
        //遍历所有单词插入tire数
        for (String word : dictionary) {
            //从根节点开始
            Trie cur = root;
            //遍历所有字母
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                //如果这个个字母不存在，则新建一个节点
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie();
                }//指向下一个节点字母
                cur = cur.child[idx];
            }
            //标记到这个节点为一个单词
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        //从root开始查询
        return dfs(searchWord, root, 0, false);
    }

    //要查询的单词，查询开始的节点，下标，是否已经改变过单词
    private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
        //判断是否已经超出单词长度
        if (pos == searchWord.length()) {
            //若已经超出则判断有没有改变过单词并且当前trie节点是不是一个单词
            return modified && node.isFinished;
        }
        //获取下标
        int idx = searchWord.charAt(pos) - 'a';
        //判断下标是否存在
        if (node.child[idx] != null) {
            //若存在则查找下一个节点
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        //若没有换过单词
        if (!modified) {
            //遍历所有中单词情况
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    //查询
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        //default
        return false;
    }

}
