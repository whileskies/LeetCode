package p147;

import common.ListNode;

import java.util.Arrays;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSorted = head, cur = head.next;

        while (cur != null) {
            ListNode next = cur.next;

            if (lastSorted.val <= cur.val) {
                lastSorted.next = cur;
                lastSorted = cur;
            } else {
                ListNode pre = dummy;
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                cur.next = pre.next;;
                pre.next = cur;
            }

            cur = next;
        }
        lastSorted.next = null;

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode a = ListNode.listToListNode(Arrays.asList(4, 2, 1, 3));
        Solution s = new Solution();
        ListNode sorted = s.insertionSortList(a);
        System.out.println(ListNode.toList(sorted));

    }

}
