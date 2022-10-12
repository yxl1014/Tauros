package yxl.demo.y2022.m10.d12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yxl
 * @date: 2022/10/12 下午3:47
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        int res = 0;
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums)
            list.add(i);
        while (head != null) {
            if (list.contains(head.val)) {
                temp++;
            } else {
                if (temp != 0) {
                    res++;
                    temp = 0;
                }
            }
            head = head.next;
        }
        if (temp != 0)
            res++;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        //ListNode head4 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        //head3.next = head4;
        System.out.println(new Solution().numComponents(head, new int[]{0,1,3}));
    }
}
