class WordDictionary {
    struct Node {
        int child[26];
        bool isEnd;

        Node() {
            fill(child, child + 26, -1);
            isEnd = false;
        }
    };

    vector<Node> trie;

    bool dfs(const string& word, int pos, int node) {
        if (pos == word.size())
            return trie[node].isEnd;

        int idx = word[pos] - 'a';

        if (word[pos] != '.') {
            int next = trie[node].child[idx];

            if (next == -1)
                return false;

            return dfs(word, pos + 1, next);
        }

        for (int i = 0; i < 26; i++) {
            int next = trie[node].child[i];

            if (next != -1 && dfs(word, pos + 1, next))
                return true;
        }

        return false;
    }

public:
    WordDictionary() {
        trie.emplace_back();
    }

    void addWord(string word) {
        int node = 0;

        for (char ch : word) {
            int idx = ch - 'a';

            if (trie[node].child[idx] == -1) {
                trie[node].child[idx] = trie.size();
                trie.emplace_back();
            }

            node = trie[node].child[idx];
        }

        trie[node].isEnd = true;
    }

    bool search(string word) {
        return dfs(word, 0, 0);
    }
};