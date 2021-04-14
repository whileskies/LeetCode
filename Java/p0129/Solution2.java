package p0129;

import common.TreeNode;

public class Solution2 {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root, 0);

        return sum;
    }

    private void dfs(TreeNode root, int num) {
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
        } else {
            if (root.left != null)
                dfs(root.left, num);
            if (root.right != null)
                dfs(root.right, num);
        }
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        TreeNode root = TreeNode.stringToTreeNode("[]");
        System.out.println(s.sumNumbers(root));
    }
}
