package p0020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (ch == ')' && top == '(') {
                    stack.pop();
                    continue;
                } else if (ch == '}' && top == '{') {
                    stack.pop();
                    continue;
                } else if (ch == ']' && top == '[') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("([{}])"));
    }
}
