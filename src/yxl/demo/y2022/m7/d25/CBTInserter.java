package yxl.demo.y2022.m7.d25;

import java.util.ArrayDeque;

/**
 * @Author: yxl
 * @Date: 2022/7/25 10:08
 */
public class CBTInserter {


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

    TreeNode root;
    int cnt;


    public CBTInserter(TreeNode root) {
        this.cnt = 0;
        this.root = root;

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        //将根节点入队
        queue.offer(root);

        //广度优先遍历
        //若队列中还存在节点说明还有节点没有遍历
        while (!queue.isEmpty()) {
            //计数器加一
            ++cnt;
            //出队
            TreeNode node = queue.poll();
            //若节点左子节点不为空则 将此节点入队
            if (node.left != null) {
                queue.offer(node.left);
            }
            //若节点右子节点不为空则 将此节点入队
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public int insert(int val) {
        ++cnt;
        TreeNode child = new TreeNode(val);
        TreeNode node = root;
        //通过节点数量判断这棵树有几层
        int highBit = 31 - Integer.numberOfLeadingZeros(cnt);
        //向下移动几层  忽略最高位的1
        for (int i = highBit - 1; i >= 1; --i) {
            //从高到低遍历每一个二进制位
            if ((cnt & (1 << i)) != 0) {
                //否则往右子节点移动
                node = node.right;
            } else {
                //如果为0就往左子节点移动
                node = node.left;
            }
        }
        if ((cnt & 1) != 0) {
            node.right = child;
        } else {
            node.left = child;
        }
        return node.val;
    }

    public TreeNode get_root() {
        return this.root;
    }

    public static void main(String[] args) {
        CBTInserter cbt=new CBTInserter(new TreeNode(1));
        cbt.insert(2);
        cbt.insert(3);
        cbt.insert(4);
        cbt.insert(5);
        cbt.insert(6);
        cbt.insert(7);
        cbt.insert(8);
        cbt.insert(9);
    }
}

