package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }


    public static ListNode listToListNode(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode p = head;
        for (int i = 1; i < list.size(); i++) {
            p.next = new ListNode(list.get(i));
            p = p.next;
        }

        return head;
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> ret = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            ret.add(p.val);
            p = p.next;
        }

        return ret;
    }

}







