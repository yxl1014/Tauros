package yxl.demo.y2022.m9.d05;

import javafx.util.Pair;

import java.util.*;

/**
 * @author yxl
 * @date: 2022/9/5 上午9:16
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/find-duplicate-subtrees/solution/xun-zhao-zhong-fu-de-zi-shu-by-leetcode-zoncw/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //使用序列化进行唯一表示
    //比较map
    Map<String, TreeNode> seen = new HashMap<String, TreeNode>();
    //结果集map
    Set<TreeNode> repeat = new HashSet<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //向下递归
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    public String dfs(TreeNode node) {
        //如果节点为null则返回空
        if (node == null) {
            return "";
        }
        //拼接序列化串
        StringBuilder sb = new StringBuilder();
        //先拼自己
        sb.append(node.val);
        sb.append("(");
        //再拼左字串
        sb.append(dfs(node.left));
        sb.append(")(");
        //再拼右字串
        sb.append(dfs(node.right));
        sb.append(")");
        String serial = sb.toString();
        //比较map
        if (seen.containsKey(serial)) {
            //若存在则说明是重复字串
            repeat.add(seen.get(serial));
        } else {
            //若不重复则添加到比较map种
            seen.put(serial, node);
        }
        //返回该串用作递归
        return serial;
    }

    Map<String, Pair<TreeNode, Integer>> seen_V2 = new HashMap<String, Pair<TreeNode, Integer>>();
    Set<TreeNode> repeat_V2 = new HashSet<TreeNode>();
    int idx = 0;

    //使用三元组进行唯一表示
    public int dfs_V2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int[] tri = {node.val, dfs_V2(node.left), dfs_V2(node.right)};
        String hash = Arrays.toString(tri);
        if (seen.containsKey(hash)) {
            Pair<TreeNode, Integer> pair = seen_V2.get(hash);
            repeat_V2.add(pair.getKey());
            return pair.getValue();
        } else {
            seen_V2.put(hash, new Pair<TreeNode, Integer>(node, ++idx));
            return idx;
        }
    }
}
