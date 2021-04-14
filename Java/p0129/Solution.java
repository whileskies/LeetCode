package p0129;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        dfs(root, path, paths);
        int sum = 0;
        for (var list : paths) {
            sum += toNum(list);
        }

        return sum;
    }

    private void dfs(TreeNode root, List<Integer> path, List<List<Integer>> paths) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            if (root.left != null)
                dfs(root.left, path, paths);
            if (root.right != null)
                dfs(root.right, path, paths);
        }

        path.remove(path.size() - 1);
    }

    private int toNum(List<Integer> path) {
        int num = 0;
        for (int i : path) {
            num = num * 10 + i;
        }

        return num;
    }




    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3]");
        System.out.println(s.sumNumbers(root));
    }
}
