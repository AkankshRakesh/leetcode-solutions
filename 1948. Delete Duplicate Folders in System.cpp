class Solution {
    struct Trie {
        string serial;
        unordered_map<string, Trie*> children;
    };

public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        Trie* root = new Trie();

        // Build the trie
        for (auto& path : paths) {
            Trie* cur = root;
            for (const string& folder : path) {
                if (!cur->children.count(folder)) {
                    cur->children[folder] = new Trie();
                }
                cur = cur->children[folder];
            }
        }

        unordered_map<string, int> freq;
        construct(root, freq);

        vector<vector<string>> ans;
        vector<string> path;
        operate(root, freq, path, ans);
        return ans;
    }

private:
    void construct(Trie* node, unordered_map<string, int>& freq) {
        if (node->children.empty()) return;

        vector<string> v;
        for (auto& [key, child] : node->children) {
            construct(child, freq);
            v.push_back(key + "(" + child->serial + ")");
        }

        sort(v.begin(), v.end());
        string serial;
        for (const string& s : v) {
            serial += s;
        }

        node->serial = serial;
        freq[serial]++;
    }

    void operate(Trie* node, unordered_map<string, int>& freq,
                 vector<string>& path, vector<vector<string>>& ans) {
        if (freq[node->serial] > 1) return;

        if (!path.empty()) {
            ans.push_back(path);
        }

        for (auto& [key, child] : node->children) {
            path.push_back(key);
            operate(child, freq, path, ans);
            path.pop_back();
        }
    }
};
