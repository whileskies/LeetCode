package p0126;

import java.util.*;

public class Solution {
    private List<List<String>> res = new ArrayList<>();
    private Set<String> wordSet = new HashSet<>();
    private Map<String, Integer> dist = new HashMap<>();


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordSet.addAll(wordList);

        bfs(beginWord, endWord);

        if (!dist.containsKey(endWord))
            return res;

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, path);

        return res;
    }

    private void bfs(String beginWord, String endWord) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        dist.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            StringBuilder sb = new StringBuilder(cur);
            for (int i = 0; i < cur.length(); i++) {
                char oriChar = sb.charAt(i);
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == cur.charAt(i)) continue;
                    sb.setCharAt(i, j);
                    String adj = sb.toString();
                    if (wordSet.contains(adj) && !dist.containsKey(adj)) {
                        dist.put(adj, dist.get(cur) + 1);
                        if (adj.equals(endWord))
                            break;
                        queue.add(adj);
                    }
                }
                sb.setCharAt(i, oriChar);
            }
        }
    }

    private void dfs(String beginWord, String endWord, List<String> path) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        StringBuilder sb = new StringBuilder(beginWord);
        for (int i = 0; i < beginWord.length(); i++) {
            char oriChar = sb.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == beginWord.charAt(i)) continue;
                sb.setCharAt(i, j);
                String adj = sb.toString();
                if (wordSet.contains(adj) && dist.containsKey(adj) && dist.get(adj) == dist.get(beginWord) + 1) {
                    path.add(adj);
                    dfs(adj, endWord, path);
                    path.remove(path.size() - 1);
                }
            }
            sb.setCharAt(i, oriChar);
        }
    }



    // 超时
    /*private void dfs(String beginWord, String endWord, List<String> path) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        StringBuilder sb = new StringBuilder(beginWord);
        for (int i = 0; i < sb.length(); i++) {
            char oriCh = sb.charAt(i);
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (sb.charAt(i) == c) continue;
                sb.setCharAt(i, c);
                String curS = sb.toString();
                if (wordMap.containsKey(curS) && !vis.contains(curS)) {
                    vis.add(curS);
                    path.add(curS);
                    dfs(curS, endWord, path);
                    vis.remove(curS);
                    path.remove(path.size() - 1);
                }
            }
            sb.setCharAt(i, oriCh);
        }
    }*/


    public static void main(String[] args) {
        Solution s = new Solution();
        String beginWord = "lost";
        String endWord = "cost";
        List<String> wordList = Arrays.asList("most", "fist", "lost", "cost", "fish");
        List<List<String>> res = s.findLadders(beginWord, endWord, wordList);
        for (var l : res) {
            System.out.println(l);
        }
    }

}
