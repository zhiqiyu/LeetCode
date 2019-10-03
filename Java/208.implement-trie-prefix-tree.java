/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */
class Trie {
    
    private class TrieNode {
        private TrieNode[] childs = new TrieNode[26];
        private boolean isEnd;
        public TrieNode() {
            isEnd = false;
            for (int i = 0; i < childs.length; i++) {
                childs[i] = null;
            }
        }
    }

    /* private variables */
    TrieNode[] rootlvl;

    /** Initialize your data structure here. */
    public Trie() {
        rootlvl = new TrieNode[26];
        for (int i = 0; i < rootlvl.length; i++) {
            rootlvl[i] = null;
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode[] curlvl = rootlvl;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (curlvl[ind] == null) {
                curlvl[ind] = new TrieNode();
            }
            if (i == word.length() - 1) curlvl[ind].isEnd = true;
            else curlvl = curlvl[ind].childs;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode[] curlvl = rootlvl;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (curlvl[ind] == null) return false;
            if ((i == word.length() - 1) && !curlvl[ind].isEnd) return false;
            curlvl = curlvl[ind].childs;
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode[] curlvl = rootlvl;
        for (int i = 0; i < prefix.length(); i++) {
            int ind = prefix.charAt(i) - 'a';
            if (curlvl[ind] == null) return false;
            curlvl = curlvl[ind].childs;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

