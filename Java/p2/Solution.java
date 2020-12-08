package p2;


import common.ListNode;

import java.util.Arrays;


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        int carry = 0;
        int sum;

        while (l1 != null || l2 != null) {
            sum = carry;
            if (l1 != null)
                sum += l1.val;
            if (l2 != null)
                sum += l2.val;

            carry = sum / 10;
            sum = sum % 10;

            p.next = new ListNode(sum);
            p = p.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return head.next;
    }


    public static void main(String[] args) {
        ListNode a = ListNode.listToListNode(Arrays.asList(2, 4, 3));
        ListNode b = ListNode.listToListNode(Arrays.asList(5, 6, 4));

        Solution solution = new Solution();
        ListNode ret = solution.addTwoNumbers(a, b);
        System.out.println(ListNode.toList(ret));

    }
}
