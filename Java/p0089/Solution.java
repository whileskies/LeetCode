package p0089;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    //超时
    public List<Integer> grayCode0(int n) {
        List<Integer> ret = new ArrayList<>();

        dfs(0, n, ret);

        return ret;
    }

    private void dfs(int begin, int n, List<Integer> ret) {
        ret.add(begin);

        if (ret.size() == (int) Math.pow(2, n)) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int next = begin ^ (1 << i);
            if (!ret.contains(next)) {
                dfs(next, n, ret);
            }
        }
    }

    //勉强通过
    public List<Integer> grayCode1(int n) {
        List<Integer> ret = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int begin = 0;
        ret.add(begin);
        set.add(begin);
        while (ret.size() < (int) Math.pow(2, n)) {
            int next;
            for (int i = 0; i < n; i++) {
                next = begin ^ (1 << i);
                if (!set.contains(next)) {
                    ret.add(next);
                    set.add(next);
                    begin = next;
                    break;
                }
            }
        }

        return ret;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            ret.add(i ^ (i >> 1));
        }

        return ret;
    }


    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = ret.size() - 1; j >= 0; j--) {
                ret.add(ret.get(j) ^ (1 << i));
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ret = s.grayCode(8);
        System.out.println(ret.size());
        for (int i : ret) {
            System.out.println(Integer.toBinaryString(i));
        }
    }
}
