class Solution {
public:
    string ans;

    bool backtrack(string &curr, int len, unordered_set<string> &hs) {
        if (curr.size() == len) {
            if (hs.find(curr) == hs.end()) {
                ans = curr;
                return true;
            }
            return false;
        }

        curr.push_back('0');
        bool res = backtrack(curr, len, hs);
        curr.pop_back();
        if (res) return true;

        curr.push_back('1');
        res = backtrack(curr, len, hs);
        curr.pop_back();

        return res;
    }

    string findDifferentBinaryString(vector<string>& nums) {
        unordered_set<string> hs;
        for (auto &s : nums) hs.insert(s);

        string curr = "";
        backtrack(curr, nums[0].size(), hs);
        return ans;
    }
};
