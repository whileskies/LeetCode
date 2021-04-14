package p0127;

import java.util.*;

public class Solution {
    private Set<String> wordSet = new HashSet<>();
    private Map<String, Integer> dist = new HashMap<>();


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet.addAll(wordList);

        return bfs(beginWord, endWord);
    }

    private int bfs(String beginWord, String endWord) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dist.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            StringBuilder sb = new StringBuilder(cur);
            for (int i = 0; i < cur.length(); i++) {
                char oriCh = sb.charAt(i);
                for (char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i, j);
                    String adj = sb.toString();

                    if (wordSet.contains(adj) && !dist.containsKey(adj)) {
                        dist.put(adj, dist.get(cur) + 1);
                        queue.offer(adj);
                        if (adj.equals(endWord))
                            break;
                    }

                }
                sb.setCharAt(i, oriCh);
            }
        }

        return dist.containsKey(endWord) ? dist.get(endWord) + 1 : 0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(s.ladderLength(beginWord, endWord, wordList));
    }
}
