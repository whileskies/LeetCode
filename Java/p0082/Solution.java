package p0082;

import common.ListNode;

public class Solution {
    public ListNode deleteDuplicates0(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(0), tail = newHead;
        ListNode pre = null, cur = head, next = head.next;

        while (cur != null) {
            if (pre == null && cur.val != next.val ||
                    next == null && pre.val != cur.val || pre != null && next != null && pre.val != cur.val && cur.val != next.val) {
                tail.next = cur;
                tail = cur;
            }

            pre = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }

        tail.next = null;

        return newHead.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }

            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[1, 2, 3, 3, 4, 4, 5]");
        ListNode newHead = s.deleteDuplicates(head);
        ListNode.prettyPrintLinkedList(newHead);
    }
}
