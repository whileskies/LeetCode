package p0141;

import common.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean hasCycle0(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; p != null; p = p.next) {
            if (set.contains(p))
                return true;
            set.add(p);
        }

        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode p = head, q = head.next;
        while (q != null && q.next != null) {
            if (p == q) return true;
            p = p.next;
            q = q.next.next;
        }

        return false;
    }
}
