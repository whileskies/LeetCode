package p0844;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getText(S).equals(getText(T));
    }

    public String getText(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return sb.toString();
    }


    public String getText2(String s) {
        Deque<Character> textStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!textStack.isEmpty())
                    textStack.removeLast();
            } else {
                textStack.addLast(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!textStack.isEmpty()) {
            sb.append(textStack.removeFirst());
        }

        return sb.toString();
    }

    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) return false;
            } else if (i >= 0 || j >= 0) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare2("a#c", "c"));
        //System.out.println(solution.getText("y#f#o##f"));
    }
}
