/*
A Trie or Prefix Tree an efficient data lookup structure - often used to store large collections of words or dictionaries. 
With a Trie, search complexities can be reduced to O(k) where k is the key or word length. 
The autocorrect on your iOS or Android keyboard uses a Trie of the most commonly used words along with fuzzy match algorithms to autocorrect and autosuggest words as you type. 
You're given a completed TrieNode class that represents one node of a Trie, and a partially complete Trie class. 
Your task is to complete the insertWord, searchWord and searchPrefix methods on the Trie class. 
Take a look at the examples below to see what each of these do. 

Example:  
trie.inserWord("AB")
trie.inserWord("ABS")
trie.inserWord("ADS")
trie.inserWord("ADSD")
trie.inserWord("ACS")

Internal Trie Structure: 

    A
  / | \
 B  C  D
 |  |  |
 S  S  S
       |
       D
*/

class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {
    }

    public TrieNode(Character c) {
        this.c = c;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        if(word == null || word.length() < 1) return;
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
            } else {
                TrieNode n = new TrieNode(c);
                children.put(c, n);
                cur = n;
            }
            children = cur.children;

            if (i == word.length() - 1) {
                cur.isLeaf = true;
            }
        }
    }

    public Boolean searchWord(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return false;
            }
        }
        return cur.isLeaf;
    }

    public Boolean searchPrefix(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return false;
            }
        }
        return true;
    }
}		