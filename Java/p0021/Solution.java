package p0021;

import common.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        p.next = p1 == null ? p2 : p1;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = ListNode.stringToListNode("[1,2,4]");
        ListNode l2 = ListNode.stringToListNode("[1,3,4]");
        ListNode head = s.mergeTwoLists(l1, l2);
        ListNode.prettyPrintLinkedList(head);
    }
}
