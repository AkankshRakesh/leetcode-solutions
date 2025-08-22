#include <vector>
#include <string>
#include <unordered_map>
#include <queue>
using namespace std;

class Solution {
    struct Pair {
        int level;
        string node;
        Pair(string n, int l) : node(n), level(l) {}
    };

public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_map<string, int> hm;
        for (string& word : wordList) hm[word] = 0;

        if (hm.find(endWord) == hm.end()) return 0;

        queue<Pair> q;
        q.push(Pair(beginWord, 1));

        while (!q.empty()) {
            Pair top = q.front();
            q.pop();
            hm[top.node] = top.level;

            string node = top.node;
            if (node == endWord) break;

            for (int i = 0; i < node.size(); i++) {
                string temp = node;
                for (int j = 0; j < 26; j++) {
                    temp[i] = 'a' + j;
                    if (hm.find(temp) != hm.end()) {
                        if (hm[temp] == 0) {
                            q.push(Pair(temp, top.level + 1));
                        }
                    }
                }
            }
        }

        return hm[endWord];
    }
};
