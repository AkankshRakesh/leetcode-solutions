public class TrieNode{
    boolean isEnd = false;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(){
        Arrays.fill(children, null);
    }
}
class WordDictionary {
    TrieNode root = new TrieNode();
    public WordDictionary() {
        
    }
    
    
    public void addWord(String word) {
        TrieNode node = root;
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }

            node = node.children[ch - 'a'];
        }

        node.isEnd = true;
    }

    public boolean dfs(String word, int index, TrieNode node){
        if(index >= word.length()) return node.isEnd;
        // System.out.println(word.charAt(index));

        char ch = word.charAt(index);
        boolean res = false;
        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null) res |= dfs(word, index + 1, node.children[i]);
            }
        }
        else{
            if(node.children[ch - 'a'] == null) return false;
            res |= dfs(word, index + 1, node.children[ch - 'a']);
        }

        return res;
    }
    
    public boolean search(String word) {
        // System.out.println("----");
        return dfs(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */