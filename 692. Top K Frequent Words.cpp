class Solution {
public:
    struct Pair {
        string word;
        int freq;
    };

    struct Compare {
        bool operator()(const Pair &a, const Pair &b) const {
            if (a.freq != b.freq) return a.freq < b.freq;
            return a.word > b.word;
        }
    };

    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> freqMap;
        for (auto &w : words) {
            freqMap[w]++;
        }

        priority_queue<Pair, vector<Pair>, Compare> pq;
        for (auto &entry : freqMap) {
            pq.push({entry.first, entry.second});
        }

        vector<string> ans;
        while (k > 0 && !pq.empty()) {
            ans.push_back(pq.top().word);
            pq.pop();
            k--;
        }
        return ans;
    }
};
