package p0143;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void reorderList0(ListNode head) {
        if (head == null) return;
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) len++;
        List<ListNode> tmp = new ArrayList<>();
        ListNode tail = head;
        for (int i = 0; i < len / 2; i++) tail = tail.next;
        ListNode p = tail.next;
        while (p != null) {
            tmp.add(p);
            p = p.next;
        }
        tail.next = null;

        ListNode pre = head, next;
        int i = tmp.size() - 1;
        while (pre.next != null) {
            next = pre.next;
            if (i < 0) break;
            ListNode node = tmp.get(i--);
            node.next = next;
            pre.next = node;
            pre = next;
        }
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode p2 = h2;
        ListNode cur = h1;
        while (cur != null && p2 != null) {
            ListNode next = cur.next;
            ListNode p2Next = p2.next;

            p2.next = next;
            cur.next = p2;

            p2 = p2Next;
            cur = next;
        }

        return h1;
    }

    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode middle = getMiddle(head);
        ListNode h2 = middle.next;
        middle.next = null;

        h2 = reverse(h2);
        merge(head, h2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.stringToListNode("[]");
        s.reorderList(head);
        ListNode.prettyPrintLinkedList(head);

    }
}
