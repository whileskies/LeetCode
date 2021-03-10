package p0092;

import common.ListNode;

public class Solution {
    public ListNode reverseBetween0(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int cnt = 0;
        ListNode p = head, rhead = head, tailhead = null, headtail = dummy, pre = dummy;

        while (p != null) {
            cnt++;
            if (cnt == m) {
                headtail = pre;
                rhead = pre.next;
            }
            if (cnt == n) tailhead = p.next;
            pre = p;
            p = p.next;
        }

        pre = null;
        ListNode cur = rhead;
        while (cur != tailhead) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        headtail.next = pre;
        rhead.next = tailhead;

        return dummy.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode left = pre.next;
        ListNode right = pre;

        for (int i = 0; i < n - m + 1; i++) {
            right = right.next;
        }

        ListNode suc = right.next;

        pre.next = null;
        right.next = null;

        reverseList(left);

        pre.next = right;
        left.next = suc;

        return dummy.next;
    }

    private void reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++)
            pre = pre.next;

        ListNode cur = pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[1, 2, 3, 4, 5]");
        ListNode res = s.reverseBetween(head, 1, 5);
        ListNode.prettyPrintLinkedList(res);
    }
}
