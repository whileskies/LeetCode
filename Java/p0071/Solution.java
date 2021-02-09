package p0071;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        List<String> simpleDirs = new ArrayList<>();

        for (String dir : dirs) {
            if (dir.length() != 0 && !dir.equals(".")) {
                if (dir.equals("..") && simpleDirs.size() != 0) {
                    simpleDirs.remove(simpleDirs.size() - 1);
                } else {
                    if (!dir.equals(".."))
                        simpleDirs.add(dir);
                }
            }
        }

        StringBuilder ret = new StringBuilder();
        for (String dir : simpleDirs) {
            ret.append('/');
            ret.append(dir);
        }

        if (simpleDirs.size() == 0)
            ret.append('/');

        return ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
    }
}
