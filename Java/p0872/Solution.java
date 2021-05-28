package p0872;

import common.TreeNode;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        return getLeaf(root1).equals(getLeaf(root2));
    }

    private String getLeaf(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null)
            return "#" + root.val + "#";
        return getLeaf(root.left) + getLeaf(root.right);
    }
}
