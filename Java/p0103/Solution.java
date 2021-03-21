package p0103;

import common.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder0(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rev = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelRes.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            if (rev)
                Collections.reverse(levelRes);
            rev = !rev;
            res.add(levelRes);
        }

        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rev = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Deque<Integer> levelRes = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (rev)
                    levelRes.offerFirst(node.val);
                else
                    levelRes.offerLast(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            rev = !rev;
            res.add(new ArrayList<>(levelRes));
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> res = s.zigzagLevelOrder(root);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }
}
