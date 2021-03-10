package p0094;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);

        return res;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            traversal(root.left, list);
            list.add(root.val);
            traversal(root.right, list);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[1,null,2]");
        List<Integer> res = s.inorderTraversal(root);
        System.out.println(res);
    }
}
