class TrieNode {
public:
    bool isEnd = false;
    TrieNode* children[26];

    TrieNode() {
        fill(children, children + 26, nullptr);
    }
};

class WordDictionary {
    TrieNode* root = new TrieNode();

public:
    WordDictionary() {
    }

    void addWord(string word) {
        TrieNode* node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word[i];

            if (node->children[ch - 'a'] == nullptr) {
                node->children[ch - 'a'] = new TrieNode();
            }

            node = node->children[ch - 'a'];
        }

        node->isEnd = true;
    }

    bool dfs(string word, int index, TrieNode* node) {
        if (index >= word.length())
            return node->isEnd;

        char ch = word[index];
        bool res = false;

        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node->children[i] != nullptr)
                    res |= dfs(word, index + 1, node->children[i]);
            }
        }
        else {
            if (node->children[ch - 'a'] == nullptr)
                return false;

            res |= dfs(word, index + 1, node->children[ch - 'a']);
        }

        return res;
    }

    bool search(string word) {
        return dfs(word, 0, root);
    }
};