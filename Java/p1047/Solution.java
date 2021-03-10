package p1047;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String removeDuplicates0(String S) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }

    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int top = -1;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (top != -1 && c == sb.charAt(top)) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(c);
                top++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates("abbaca"));
    }
}
