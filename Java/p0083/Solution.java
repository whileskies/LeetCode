package p0083;

import common.ListNode;

public class Solution {
    public ListNode deleteDuplicates0(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(-1), tail = newHead;
        ListNode p = head, nextP = head.next;

        while (p.next != null) {
            if (p.val != nextP.val) {
                tail.next = p;
                tail = p;
            }
            p = p.next;
            nextP = nextP.next;
        }

        tail.next = p;

        return newHead.next;
    }


    public ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[1, 1, 1, 2,  2, 3, 3]");
        ListNode newHead = s.deleteDuplicates(head);
        ListNode.prettyPrintLinkedList(newHead);
    }
}
