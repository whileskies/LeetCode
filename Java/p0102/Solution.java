package p0102;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    static class Node {
        TreeNode tree;
        int level;

        public Node(TreeNode tree, int level) {
            this.tree = tree;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder0(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root == null) return res;
        Node n = new Node(root, 1);
        queue.offer(n);
        List<Integer> levelList = new ArrayList<>();
        int curLevel = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.level != curLevel) {
                res.add(new ArrayList<>(levelList));
                curLevel = cur.level;
                levelList.clear();
            }
            levelList.add(cur.tree.val);

            if (cur.tree.left != null)
                queue.offer(new Node(cur.tree.left, cur.level + 1));
            if (cur.tree.right != null)
                queue.offer(new Node(cur.tree.right, cur.level + 1));
        }

        res.add(new ArrayList<>(levelList));

        return res;
    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode t = queue.poll();
                level.add(t.val);

                if (t.left != null)
                    queue.offer(t.left);
                if (t.right != null)
                    queue.offer(t.right);
            }

            res.add(level);
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> res = s.levelOrder(root);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }
}
