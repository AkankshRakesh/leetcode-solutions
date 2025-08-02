class Trie {
public:
    Trie* children[26];
    bool isEndOfWord;

    Trie() {
        isEndOfWord = false;
        for (int i = 0; i < 26; ++i) {
            children[i] = nullptr;
        }
    }

    void insert(string word) {
        Trie* node = this;
        for (char ch : word) {
            if (node->children[ch - 'a'] == nullptr) {
                node->children[ch - 'a'] = new Trie();
            }
            node = node->children[ch - 'a'];
        }
        node->isEndOfWord = true;
    }

    bool search(string word) {
        Trie* node = this;
        for (char ch : word) {
            if (node->children[ch - 'a'] == nullptr) {
                return false;
            }
            node = node->children[ch - 'a'];
        }
        return node->isEndOfWord;
    }

    bool startsWith(string prefix) {
        Trie* node = this;
        for (char ch : prefix) {
            if (node->children[ch - 'a'] == nullptr) {
                return false;
            }
            node = node->children[ch - 'a'];
        }
        return true;
    }
};
