package p0208;

import java.io.StreamTokenizer;

public class Trie {
    private static class TrieNode {
        TrieNode[] nodes;
        boolean end;
    }

    private final TrieNode root;

    public static final int LEN = 26;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.nodes = new TrieNode[LEN];
        root.end = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode[] nodes = root.nodes;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (nodes[index] == null) {
                nodes[index] = new TrieNode();
                nodes[index].end = false;
                nodes[index].nodes = new TrieNode[LEN];
            }

            if (i == word.length() - 1)
                nodes[index].end = true;

            nodes = nodes[index].nodes;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode[] nodes = root.nodes;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (nodes[index] == null)
                return false;

            if (i == word.length() - 1 && !nodes[index].end)
                return false;

            nodes = nodes[index].nodes;
        }

        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode[] nodes = root.nodes;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if (nodes[index] == null)
                return false;

            nodes = nodes[index].nodes;
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));;
        System.out.println(trie.search("app"));
    }
}
