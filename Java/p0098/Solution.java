package p0098;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isValidBST0(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long low, long upper) {
        if (root == null)
            return true;
        if (root.val <= low || root.val >= upper)
            return false;
        return check(root.left, low, root.val) && check(root.right, root.val, upper);
    }


    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long last = Long.MIN_VALUE;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (cur.val <= last)
                return false;
            last = cur.val;
            cur = cur.right;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[-2147483648]");
        System.out.println(s.isValidBST(root));
    }


}
