package yxl.demo.y2022.m6.d19;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int ii = searchPre(root, 0, map);
        List<Integer> list = new ArrayList<>();

        int max = -1;
        for (Integer i : map.keySet()) {
            if (map.get(i) > max)
                max = map.get(i);
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) == max)
                list.add(i);
        }


        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int searchPre(TreeNode node, int sum, Map<Integer, Integer> map) {
        int is = 0;
        is += node.val;
        if (node.left != null)
            is = searchPre(node.left, is, map);
        if (node.right != null)
            is = searchPre(node.right, is, map);


        if (map.containsKey(is))
            map.put(is, map.get(is) + 1);
        else
            map.put(is, 1);

        sum += is;

        return sum;
    }
}
