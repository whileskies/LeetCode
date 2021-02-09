package p0049;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams0(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append(i + 'a');
                    sb.append(count[i]);
                }
            }

            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        List<List<String>> lists = s.groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
