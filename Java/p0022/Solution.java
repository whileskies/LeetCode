package p0022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0) return ret;
        StringBuilder sb = new StringBuilder();
        dfs(ret, sb, n);

        return ret;
    }

    private void dfs0(List<String> ret, StringBuilder parenthesesPath, int n) {
        int nLeft = 0, nRight = 0;
        for (int i = 0; i < parenthesesPath.length(); i++) {
            if (parenthesesPath.charAt(i) == '(')
                nLeft++;
            else
                nRight++;
        }

        if (nLeft == nRight && nLeft == n) {
            ret.add(parenthesesPath.toString());
            return;
        }
        if (nLeft == nRight) {
            parenthesesPath.append('(');
            dfs(ret, parenthesesPath, n);
        } else if (nLeft == n && nLeft + nRight != 2 * n) {
            parenthesesPath.append(')');
            dfs(ret, parenthesesPath, n);
        } else {
            parenthesesPath.append('(');
            dfs(ret, parenthesesPath, n);
            parenthesesPath.deleteCharAt(parenthesesPath.length() - 1);
            parenthesesPath.append(')');
            dfs(ret, parenthesesPath, n);
        }
        parenthesesPath.deleteCharAt(parenthesesPath.length() - 1);
    }

    private void dfs(List<String> ret, StringBuilder parenthesesPath, int n) {
        int nLeft = 0, nRight = 0;
        for (int i = 0; i < parenthesesPath.length(); i++) {
            if (parenthesesPath.charAt(i) == '(')
                nLeft++;
            else
                nRight++;
        }

        if (nLeft == nRight && nLeft == n) {
            ret.add(parenthesesPath.toString());
            return;
        }

        if (nLeft < n) {
            parenthesesPath.append('(');
            dfs(ret, parenthesesPath, n);
            parenthesesPath.deleteCharAt(parenthesesPath.length() - 1);
        }

        if (nRight < nLeft) {
            parenthesesPath.append(')');
            dfs(ret, parenthesesPath, n);
            parenthesesPath.deleteCharAt(parenthesesPath.length() - 1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ret = s.generateParenthesis(3);
        System.out.println(ret);
    }
}
