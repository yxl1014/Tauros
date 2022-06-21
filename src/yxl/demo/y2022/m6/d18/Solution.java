package yxl.demo.y2022.m6.d18;

public class Solution {
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        if (head.next == head) {
            head.next = new Node(insertVal, head);
            return head;
        }


        Node temp = head;
        Node pre = null;
        do {
            if (insertVal > temp.val && insertVal <= temp.next.val) {
                temp.next = new Node(insertVal, temp.next);
                return head;
            }
            if (insertVal > temp.val && temp.val > temp.next.val) {
                temp.next = new Node(insertVal, temp.next);
                return head;
            }
            if (insertVal < temp.val && insertVal <= temp.next.val && temp.val > temp.next.val) {
                temp.next = new Node(insertVal, temp.next);
                return head;
            }
            pre = temp;
            temp = temp.next;
        } while (temp != head);
        pre.next = new Node(insertVal, pre.next);

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node h = new Node(5);
        Node h1 = new Node(1);
        head.next = h;
        h.next = h1;
        h1.next = head;
        Solution solution = new Solution();
        head = solution.insert(head, 0);
        System.out.println(head.val);
    }
}
