package p0783;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Solution {
    private int res = Integer.MAX_VALUE;
    private TreeNode pre;

    public int minDiffInBST(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[4,2,6,1,3]");
        System.out.println(s.minDiffInBST(root));
    }
}
