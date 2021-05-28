package p0692;

import java.util.*;

public class Solution {
    public List<String> topKFrequent0(String[] words, int k) {
        Map<String, Integer> cntMap = new TreeMap<>();
        for (String s : words) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(cntMap.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }

        return res;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String s : words) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return o2.getKey().compareTo(o1.getKey());
            else
                return o1.getValue() - o2.getValue();
        });

        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll().getKey());
        Collections.reverse(res);
        return res;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(s.topKFrequent(words, 2));
    }
}
