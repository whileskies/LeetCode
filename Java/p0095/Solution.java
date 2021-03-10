package p0095;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> leftRes = generate(l, i - 1);
            List<TreeNode> rightRes = generate(i + 1, r);

            for (TreeNode leftTree : leftRes) {
                for (TreeNode rightTree : rightRes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<TreeNode> res = s.generateTrees(3);

        for (TreeNode root : res) {
            TreeNode.prettyPrintTree(root);
            System.out.println();
        }
    }
}
