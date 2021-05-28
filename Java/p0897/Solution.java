package p0897;

import common.TreeNode;

public class Solution {
    private TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        pre = dummy;
        inOrder(root);

        return dummy.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);

        pre.right = root;
        root.left = null;
        pre = root;

        inOrder(root.right);
    }
}
