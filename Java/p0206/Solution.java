package p0206;

import common.ListNode;

public class Solution {
    public ListNode reverseList0(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(0);
        ListNode p = head;

        while (p != null) {
            ListNode next = p.next;

            p.next = newHead.next;
            newHead.next = p;

            p = next;
        }

        return newHead.next;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[1, 2, 3, 4, 5]");
        head = s.reverseList(head);
        ListNode.prettyPrintLinkedList(head);
    }
}
