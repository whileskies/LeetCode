package p0100;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else {
            pQueue.offer(p);
            qQueue.offer(q);
        }

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pRoot = pQueue.poll();
            TreeNode qRoot = qQueue.poll();

            if (pRoot.val != qRoot.val || pRoot.left == null && qRoot.left != null ||
                pRoot.right == null && qRoot.right != null)
                return false;

            if (pRoot.left != null) pQueue.offer(pRoot.left);
            if (pRoot.right != null) pQueue.offer(pRoot.right);
            if (qRoot.left != null) qQueue.offer(qRoot.left);
            if (qRoot.right != null) qQueue.offer(qRoot.right);
        }

        return pQueue.isEmpty() && qQueue.isEmpty();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        TreeNode p = TreeNode.stringToTreeNode("[1, 2, 3]");
        TreeNode q = TreeNode.stringToTreeNode("[1, 2, 3]");
        System.out.println(s.isSameTree(p, q));
    }
}
