class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, int> hm;
        vector<vector<string>> ans;

        for (string str : strs) {
            vector<int> arr(26, 0);

            for (char ch : str) {
                arr[ch - 'a']++;
            }

            // Build unique key for hashmap
            string sortedStr;
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    sortedStr += (char)('a' + i);
                    sortedStr += to_string(arr[i]);
                }
            }

            if (hm.find(sortedStr) == hm.end()) {
                hm[sortedStr] = ans.size();
                ans.push_back({str});
            } else {
                ans[hm[sortedStr]].push_back(str);
            }
        }

        return ans;
    }
};
