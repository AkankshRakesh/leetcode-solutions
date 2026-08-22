class Solution {
public:
    void makeSubseq(string s, int index, unordered_set<string>& hs, string& sb) {
        if (index >= s.length()) {
            hs.insert(sb);
            return;
        }

        makeSubseq(s, index + 1, hs, sb);
        sb.push_back(s[index]);
        makeSubseq(s, index + 1, hs, sb);
        sb.pop_back();
    }

    int findLUSlength(vector<string>& strs) {
        unordered_map<int, unordered_set<string>> hm;

        for (int i = 0; i < strs.size(); i++) {
            unordered_set<string> hs;
            string sb;
            makeSubseq(strs[i], 0, hs, sb);
            hm[i] = hs;
        }

        int ans = -1;

        for (int i = 0; i < strs.size(); i++) {
            unordered_set<string>& curr = hm[i];

            for (string str : curr) {
                if (str == "") continue;

                bool found = false;

                for (int j = 0; j < strs.size(); j++) {
                    if (i == j) continue;

                    unordered_set<string>& hs = hm[j];

                    if (hs.count(str)) {
                        found = true;
                        break;
                    }
                }

                if (!found)
                    ans = max(ans, (int)str.length());
            }
        }

        return ans;
    }
};