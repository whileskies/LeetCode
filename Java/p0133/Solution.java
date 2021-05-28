package p0133;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}

public class Solution {
    private Map<Integer, Node> map = new HashMap<>();

    //bfs
    public Node cloneGraph0(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node n : cur.neighbors) {
                if (!map.containsKey(n.val)) {
                    Node newN = new Node(n.val, new ArrayList<>());
                    map.put(n.val, newN);
                    queue.offer(n);
                }
                map.get(cur.val).neighbors.add(map.get(n.val));
            }
        }

        return newNode;
    }

    // dfs
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        dfs(node);
        return map.get(node.val);
    }

    private void dfs(Node node) {
        if (!map.containsKey(node.val)) {
            Node newNode = new Node(node.val);
            map.put(node.val, newNode);
            for (Node n : node.neighbors) {
                dfs(n);
                newNode.neighbors.add(map.get(n.val));
            }
        }
    }



    public static void main(String[] args) {
        Solution s = new Solution();

        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node newN1 = s.cloneGraph(n1);
    }
}
