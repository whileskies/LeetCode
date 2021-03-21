package p0101;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric0(TreeNode root) {
        if (root == null)
            return true;
        return treesIsSym(root.left, root.right);
    }

    private boolean treesIsSym(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        return p.val == q.val && treesIsSym(p.left, q.right) && treesIsSym(p.right, q.left);
    }


    // bfs
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return bfsCheck(root.left, root.right);
    }

    public boolean bfsCheck(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null)
                continue;
            if (p == null || q == null)
                return false;
            if (p.val != q.val)
                return false;

            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }

        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[1,2,2,3,4,4,3]");
        System.out.println(s.isSymmetric(root));
    }
}
