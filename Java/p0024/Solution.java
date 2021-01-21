package p0024;

import common.ListNode;

public class Solution {
    public ListNode swapPairs0(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = pre.next;

        while (cur != null && cur.next != null) {
            ListNode second = cur.next;
            cur.next = second.next;
            second.next = cur;
            pre.next = second;

            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;

        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode newHead = s.swapPairs(head);
        ListNode.prettyPrintLinkedList(newHead);
    }
}
