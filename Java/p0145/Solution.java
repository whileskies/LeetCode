package p0145;

import common.TreeNode;

import java.util.*;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }

            root = stack.pop().left;
        }

        Collections.reverse(res);

        return res;
    }
}
