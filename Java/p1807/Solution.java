package p1807;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                ret.append(s.charAt(i));
            } else {
                int j = i + 1;
                StringBuilder key = new StringBuilder();
                while (s.charAt(j) != ')') {
                    key.append(s.charAt(j));
                    j++;
                }
                ret.append(map.getOrDefault(key.toString(), "?"));
                i = j;
            }
        }

        return ret.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> a = Arrays.asList("name", "bob");
        List<String> b = Arrays.asList("age", "two");
        List<List<String>> know = Arrays.asList(a, b);
        System.out.println(s.evaluate("(name)is(age)yearsold", know));
    }
}
