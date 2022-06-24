package yxl.demo.y2022.m6.d24;

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
    }

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        preMax(root, 0, map);
        List<Integer> list = new ArrayList<>();
        list.addAll(map.values());
        return list;
    }

    private void preMax(TreeNode root, int s, Map<Integer, Integer> map) {
        int sl = s + 1;
        if (root == null)
            return;
        if (map.containsKey(sl)) {
            if (map.get(sl) < root.val)
                map.put(sl, root.val);
        } else {
            map.put(sl, root.val);
        }

        if (root.left != null) {
            preMax(root.left, sl, map);
        }

        if (root.right != null) {
            preMax(root.right, sl, map);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(9);
        n1.left = n3;
        n1.right = n2;
        n3.left = n5;
        n3.right = n4;
        n2.right = n6;
        System.out.println(Arrays.toString(s.largestValues(n1).toArray()));
    }
}
