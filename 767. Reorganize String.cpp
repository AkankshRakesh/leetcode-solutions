#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    struct Pair {
        int count;
        char letter;
        Pair(char l, int c) : count(c), letter(l) {}
    };

    struct Compare {
        bool operator()(const Pair& a, const Pair& b) {
            return a.count < b.count; // max heap
        }
    };

    string reorganizeString(string s) {
        string result;
        priority_queue<Pair, vector<Pair>, Compare> pq;
        unordered_map<char, int> freq;
        int n = s.size();

        for (int i = 0; i < n; i++) {
            freq[s[i]]++;
        }

        for (auto& [ch, cnt] : freq) {
            pq.push(Pair(ch, cnt));
        }

        while (!pq.empty() && pq.size() >= 2) {
            Pair first = pq.top(); pq.pop();
            Pair second = pq.top(); pq.pop();

            if (result.empty() || result.back() != first.letter) {
                result.push_back(first.letter);
                result.push_back(second.letter);
            } else {
                result.push_back(second.letter);
                result.push_back(first.letter);
            }

            if (first.count > 1) pq.push(Pair(first.letter, first.count - 1));
            if (second.count > 1) pq.push(Pair(second.letter, second.count - 1));
        }

        if (!pq.empty()) {
            Pair last = pq.top();
            if (result.empty() || result.back() != last.letter) {
                if (last.count > 1) return "";
                result.push_back(last.letter);
            } else return "";
        }

        return result;
    }
};
