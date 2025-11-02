class Solution {
public:
    struct Pair {
        char ch;
        int count;
        Pair(char c, int cnt) : ch(c), count(cnt) {}
    };

    struct Compare {
        bool operator()(const Pair& a, const Pair& b) {
            return a.count < b.count; 
        }
    };

    string reorganizeString(string s) {
        priority_queue<Pair, vector<Pair>, Compare> pq;
        unordered_map<char, int> freq;

        for (char ch : s) freq[ch]++;

        for (auto& [ch, cnt] : freq) pq.push(Pair(ch, cnt));

        string result;

        while (!pq.empty() && pq.size() >= 2) {
            Pair first = pq.top(); pq.pop();
            Pair second = pq.top(); pq.pop();

            result += first.ch;
            result += second.ch;

            if (first.count > 1) pq.push(Pair(first.ch, first.count - 1));
            if (second.count > 1) pq.push(Pair(second.ch, second.count - 1));
        }

        if (!pq.empty()) {
            Pair last = pq.top();
            if (last.count == 1 && (result.empty() || result.back() != last.ch))
                result += last.ch;
            else
                return "";
        }

        return result;
    }
};