class Solution {
public:
    vector<int> count(const string& s) {
        vector<int> ans(26, 0);
        for (char c : s) {
            ans[c - 'a']++;
        }
        return ans;
    }
    vector<string> wordSubsets(vector<string>& A, vector<string>& B) {
        vector<int> bmax(26, 0);

        for (const string& b : B) {
            vector<int> bCount = count(b);
            for (int i = 0; i < 26; ++i) {
                bmax[i] = max(bmax[i], bCount[i]);
            }
        }

        vector<string> ans;

        for (const string& a : A) {
            vector<int> aCount = count(a);
            bool isUniversal = true;
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                ans.push_back(a);
            }
        }

        return ans;
    }
};