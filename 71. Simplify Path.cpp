class Solution {
public:
    string simplifyPath(string path) {
        deque<string> q;
        string curr;
        for (size_t i = 1; i < path.length(); i++) {
            char ch = path[i];
            if (ch == '/') {
                if (curr.empty() || curr == ".") {
                    curr.clear();
                    continue;
                }
                if (curr == "..") {
                    if (!q.empty()) q.pop_back();
                } else {
                    q.push_back(curr);
                }
                curr.clear();
            } else {
                curr.push_back(ch);
            }
        }
        if (curr == "..") {
            if (!q.empty()) q.pop_back();
        } else if (!curr.empty() && curr != ".") {
            q.push_back(curr);
        }

        string ans = "/";
        while (!q.empty()) {
            ans += q.front();
            q.pop_front();
            if (!q.empty()) ans += "/";
        }

        return ans;
    }
};

