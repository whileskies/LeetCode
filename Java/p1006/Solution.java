package p1006;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int clumsy0(int N) {
        List<Integer> nums = new ArrayList<>();
        int n = N;
        while (n > 0) {
            int tmp = n;
            n--;
            if (n < 1) {
                nums.add(tmp);
                break;
            }
            tmp *= n;
            n--;
            if (n < 1) {
                nums.add(tmp);
                break;
            }
            tmp /= n;
            nums.add(tmp);
            n--;
            if (n < 1) break;
            nums.add(n);
            n--;
        }

//        System.out.println(nums);

        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (i % 2 == 1) {
                res = res + nums.get(i);
            } else {
                res = res - nums.get(i);
            }
        }

        return res;
    }

    public int clumsy1(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N--);
        int index = 0;
        while (N > 0) {
            if (index % 4 == 0)
                stack.push(stack.pop() * N);
            else if (index % 4 == 1)
                stack.push(stack.pop() / N);
            else if (index % 4 == 2)
                stack.push(N);
            else
                stack.push(-N);
            N--;
            index++;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public int clumsy(int N) {
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 6;
        if (N == 4) return 7;

        if (N % 4 == 0) return N + 1;
        if (N % 4 <= 2) return N + 2;

        return N - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i + " " + s.clumsy(i));
        }
//        System.out.println(s.clumsy(1));
    }
}
