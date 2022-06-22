package yxl.demo.y2022.m6.d22;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *     作者：LeetCode-Solution
 *     链接：https://leetcode.cn/problems/find-bottom-left-tree-value/solution/zhao-shu-zuo-xia-jiao-de-zhi-by-leetcode-weeh/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution_GuangDuYouXiang {
    public int findBottomLeftValue(Solution.TreeNode root) {
        int ret = 0;
        Queue<Solution.TreeNode> queue = new ArrayDeque<Solution.TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Solution.TreeNode p = queue.poll();
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left != null) {
                queue.offer(p.left);
            }
            ret = p.val;
        }
        return ret;
    }
}
