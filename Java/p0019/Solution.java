package p0019;

import common.ListNode;

import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd0(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = getListLen(head);
        int nth = len - n;

        int cur = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            if (cur == nth) {
                p.next = p.next.next;
                break;
            }
            cur++;
        }

        return dummy.next;
    }

    private int getListLen(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }


    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int i = 0;
        ListNode pi = dummy;
        int j = 0;
        ListNode pj = dummy;

        while (pj != null) {
            if (j - i >= n + 1) {
                i++;
                pi = pi.next;
            }
            j++;
            pj = pj.next;
        }

        pi.next = pi.next.next;

        return dummy.next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pi = dummy;
        ListNode pj = head;

        for (int i = 0; i < n; i++) {
            pj = pj.next;
        }

        while (pj != null) {
            pi = pi.next;
            pj = pj.next;
        }

        pi.next = pi.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[1,2,3,4,5]");
        ListNode.prettyPrintLinkedList(head);
        head = s.removeNthFromEnd(head, 2);
        ListNode.prettyPrintLinkedList(head);
    }
}
