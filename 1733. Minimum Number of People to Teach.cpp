class Solution {
public:
    bool check(const unordered_set<int>& hs1, const unordered_set<int>& hs2) {
        if (hs1.size() < hs2.size()) {
            for (auto lang : hs1)
                if (hs2.count(lang)) return true;
        } else {
            for (auto lang : hs2)
                if (hs1.count(lang)) return true;
        }
        return false;
    }

    int minimumTeachings(int n, vector<vector<int>>& languages, vector<vector<int>>& friendships) {
        unordered_map<int, unordered_set<int>> hm;
        int people = (int)languages.size();

        for (int i = 0; i < people; i++) {
            unordered_set<int> hs;
            for (int lang : languages[i]) hs.insert(lang);
            hm[i + 1] = hs;  // person index starts at 1
        }

        unordered_set<int> needTeach;
        for (auto& f : friendships) {
            int a = f[0], b = f[1];
            if (!check(hm[a], hm[b])) {
                needTeach.insert(a);
                needTeach.insert(b);
            }
        }

        if (needTeach.empty()) return 0;

        int ans = INT_MAX;

        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int p : needTeach)
                if (!hm[p].count(lang)) count++;
            ans = min(ans, count);
        }

        return ans;
    }
};
