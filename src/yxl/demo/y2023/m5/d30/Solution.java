package yxl.demo.y2023.m5.d30;

import java.util.*;

public class Solution {
    public static class TreeNode {
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

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<Integer>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        List<TreeNode> roots = new ArrayList<TreeNode>();
        dfs(root, true, toDeleteSet, roots);
        return roots;
    }

    public TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> roots) {
        if (node == null) {
            return null;
        }
        boolean deleted = toDeleteSet.contains(node.val);
        node.left = dfs(node.left, deleted, toDeleteSet, roots);
        node.right = dfs(node.right, deleted, toDeleteSet, roots);
        if (deleted) {
            return null;
        } else {
            if (isRoot) {
                roots.add(node);
            }
            return node;
        }
    }
}
