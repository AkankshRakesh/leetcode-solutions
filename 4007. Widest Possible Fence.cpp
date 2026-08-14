class Solution {
public:
    int maximumWidth(vector<int>& planks) {
        unordered_map<long long, int> freq;
        for (int plank : planks) {
            freq[(long long)plank] = freq.count((long long)plank) ? freq[(long long)plank] + 1 : 1;
        }

        vector<long long> values(freq.size());
        int index = 0;

        for (auto& entry : freq) {
            values[index++] = entry.first;
        }

        unordered_map<long long, int> pairs;
        for (int i = 0; i < values.size(); i++) {
            long long x = values[i];

            int samePairs = freq[x] / 2;
            if (samePairs > 0) {
                pairs[x + x] = pairs.count(x + x) ? pairs[x + x] + samePairs : samePairs;
            }

            for (int j = i + 1; j < values.size(); j++) {
                long long y = values[j];
                long long sum = x + y;

                int pair = min(freq[x], freq[y]);

                pairs[sum] = pairs.count(sum) ? pairs[sum] + pair : pair;
            }
        }

        int ans = 1;
        for (auto& ele : pairs) {
            ans = max(ans, ele.second + (freq.count(ele.first) ? freq[ele.first] : 0));
        }

        for (auto& entry : freq) {
            ans = max(ans, entry.second);
        }

        return ans;
    }
};