package p0104;

import common.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[3, 9, 20, null, null, 15, 7]");
        System.out.println(s.maxDepth(root));
    }
}
