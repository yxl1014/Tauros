package yxl.demo.y2023.m1.d30;

/**
 * @author yxl
 * @date 2023/1/30 下午4:36
 */
public class Solution {
    public class ListNode {
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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = null;
        ListNode temp = list1;
        for (int i = 0; i < a; i++) {
            pre = temp;
            temp = temp.next;
        }
        ListNode end1 = null;
        for (int i = 0; i < b - a + 1; i++) {
            temp = temp.next;
        }
        end1 = temp;
        ListNode end2 = list2;
        while (end2.next != null) {
            end2 = end2.next;
        }
        pre.next = list2;
        end2.next = end1;

        return list1;
    }
}
