package yxl.demo.y2023.m6.d12;

import java.util.HashMap;
import java.util.Map;

/**
 * 超出时间限制
 */
public class TreeAncestor {
    private int n;
    private int[] parent;

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
    }

    public int getKthAncestor(int node, int k) {
        if (k > n || node >= n) {
            return -1;
        }
        int res = node;
        for (int i = 0; i < k; i++) {
            res = parent[res];
            if (res == -1) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }
}
