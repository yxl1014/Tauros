package yxl.demo.y2022.m6.d22;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

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
    }

    public List<Pair<Integer, Integer>> list = new ArrayList<>();
    public int level = 1;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        findPre(root, 1);
        for (Pair<Integer, Integer> p : list) {
            if (this.level == p.getKey()) {
                return p.getValue();
            }
        }
        return -1;
    }

    private void findPre(TreeNode node, int level) {
        int l = level + 1;
        if (node.left == null && node.right == null) {
            list.add(new Pair<>(level + 1, node.val));
            if (this.level < l)
                this.level = l;
        }

        if (node.left != null)
            findPre(node.left, l);

        if (node.right != null)
            findPre(node.right, l);

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        Solution solution = new Solution();
        System.out.println(solution.findBottomLeftValue(n1));
    }
}
