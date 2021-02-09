package p0061;

import common.ListNode;

public class Solution {
    public ListNode rotateRight0(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = 0;
        ListNode cur = dummy.next;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        for (int i = 0; i < k % len; i++) {
            ListNode p = dummy.next;
            ListNode pre = dummy;
            while (p.next != null) {
                pre = p;
                p = p.next;
            }

            pre.next = null;
            p.next = dummy.next;
            dummy.next = p;
        }

        return dummy.next;
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        if (k % len == 0)
            return head;

        p = head;
        ListNode tail = p, pre = null;
        for (int i = 0; i < (len - k % len); i++) {
            pre = p;
            p = p.next;
            tail = p;
        }

        while (tail.next != null) {
            tail = tail.next;
        }

        if (pre != null)
            pre.next = null;
        tail.next = head;
        head = p;

        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[1, 2, 3, 4, 5]");
        ListNode rotated = s.rotateRight(head, 2);
        ListNode.prettyPrintLinkedList(rotated);
    }
}
