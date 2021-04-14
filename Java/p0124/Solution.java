package p0124;

import common.TreeNode;

public class Solution {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        res = Math.max(res, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println(s.maxPathSum(root));
    }
}
