package p0093;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses0(String s) {
        List<String> res = new ArrayList<>();
        List<String> ip = new ArrayList<>();
        int n = s.length();

        int a, b, c, d;
        for (a = 1; a <= 3; a++) {
            for (b = 1; b <= 3; b++) {
                for (c = 1; c <= 3; c++) {
                    d = n - (a + b + c);
                    if (d > 3 || d < 1)
                        continue;
                    String sub1 = s.substring(0, a);
                    String sub2 = s.substring(a, a + b);
                    String sub3 = s.substring(a + b, a + b + c);
                    String sub4 = s.substring(a + b + c, n);
                    if (validIp(sub1) && validIp(sub2) && validIp(sub3) && validIp(sub4)) {
                        res.add(sub1 + "." + sub2 + "." + sub3 + "." + sub4);
                    }
                }
            }
        }

        return res;
    }

    private boolean validIp(String ip) {
        int num = Integer.parseInt(ip);
        if (num < 0 || num > 255)
            return false;
        if (num == 0 && ip.length() > 1)
            return false;
        if (num != 0 && ip.charAt(0) == '0')
            return false;
        return true;
    }


    // dfs
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(s, 0, s.length(), path, res);

        return res;
    }

    private void dfs(String s, int b, int n, List<String> path, List<String> res) {
        if (path.size() == 4 && n > 0)
            return;
        else if (path.size() == 4 && n == 0) {
            res.add(path.get(0) + "." + path.get(1) + "." + path.get(2) + "." + path.get(3));
            return;
        }

        for (int l = 1; l <= 3; l++) {
            if (l > n)
                break;
            String sub = s.substring(b, b + l);
            if (sub.charAt(0) == '0' && l != 1)
                break;
            int num = Integer.parseInt(sub);
            if (num > 255)
                break;
            path.add(sub);
            dfs(s, b + l, n - l, path, res);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.restoreIpAddresses("0000");
        System.out.println(res);
    }
}
