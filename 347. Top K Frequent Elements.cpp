class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> freq;
        for (int num : nums) {
            freq[num]++;
        }

        vector<pair<int, int>> freqVec(freq.begin(), freq.end());
        
        // Sort in descending order of frequency
        sort(freqVec.begin(), freqVec.end(), [](pair<int, int>& a, pair<int, int>& b) {
            return b.second < a.second;
        });

        vector<int> result;
        for (int i = 0; i < k; ++i) {
            result.push_back(freqVec[i].first);
        }

        return result;
    }
};
