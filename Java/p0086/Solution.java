package p0086;

import common.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode leDummy = new ListNode(-1), leTail = leDummy;
        ListNode gtDummy = new ListNode(-1), gtTail = gtDummy;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                leTail.next = p;
                leTail = p;
            } else {
                gtTail.next = p;
                gtTail = p;
            }

            p = p.next;
        }

        leTail.next = gtDummy.next;
        gtTail.next = null;

        return leDummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[2, 1]");
        ListNode ret = s.partition(head, 2);
        ListNode.prettyPrintLinkedList(ret);
    }
}
