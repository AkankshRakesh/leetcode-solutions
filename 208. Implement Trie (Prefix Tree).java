class Trie {
    Trie[] children;
    boolean isEndOfWord;

    public Trie() {
        isEndOfWord = false;

        children = new Trie[26];    
    }
    
    public void insert(String word) {
        Trie node = this;
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] == null){
                Trie temp = new Trie();

                node.children[ch - 'a'] = temp;
            }
            
            node = node.children[ch - 'a'];
        }

        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        int n = word.length();
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] == null) return false;

            node = node.children[ch - 'a'];
        }

        return node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        int n = prefix.length();
        for(int i = 0; i < n; i++){
            char ch = prefix.charAt(i);
            if(node.children[ch - 'a'] == null) return false;
            // if(node.children[ch - 'a'].isEndOfWord && i != n - 1) return false;

            node = node.children[ch - 'a'];
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