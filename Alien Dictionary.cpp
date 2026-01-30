class Solution {
public:
    std::string findOrder(std::vector<std::string>& words) {
        std::unordered_map<char, std::unordered_set<char>> adj;
        std::unordered_map<char, int> inDeg;
        for (const auto& word : words) {
            for (char c : word) {
                inDeg[c] = 0;
            }
        }
        int totalChars = inDeg.size();

        for (size_t i = 1; i < words.size(); i++) {
            const std::string& past = words[i - 1];
            const std::string& curr = words[i];
            size_t l1 = 0, l2 = 0;
            while (l1 < past.size() && l2 < curr.size()) {
                if (past[l1] != curr[l2]) {
                    if (adj.count(past[l1])) {
                        if (!adj[past[l1]].count(curr[l2])) {
                            inDeg[curr[l2]]++;
                        }
                        adj[past[l1]].insert(curr[l2]);
                    } else {
                        adj[past[l1]] = {curr[l2]};
                        inDeg[curr[l2]]++;
                    }
                    break;
                }
                l1++;
                l2++;
            }
            if (l1 < past.size() && l2 == curr.size()) return "";
        }

        std::queue<char> q;
        for (const auto& ele : inDeg) {
            if (ele.second == 0) q.push(ele.first);
        }

        std::string sb;
        while (!q.empty()) {
            char ch = q.front();
            q.pop();
            sb.push_back(ch);

            if (!adj.count(ch)) continue;
            for (char neig : adj[ch]) {
                inDeg[neig]--;
                if (inDeg[neig] == 0) {
                    q.push(neig);
                }
            }
        }

        if (sb.size() != inDeg.size()) return "";
        return sb;
    }
};