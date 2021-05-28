package p0138;

import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        for (Node cur = head, pre = null; cur != null; pre = cur, cur = cur.next) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            map.get(pre).next = newNode;
        }

        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).random = map.get(cur.random);
        }

        return map.get(head);
    }
}
