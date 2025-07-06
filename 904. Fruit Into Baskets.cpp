class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        unordered_map<int, int> hm;
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.size(); ++right) {
            hm[fruits[right]]++;

            while (hm.size() > 2) {
                hm[fruits[left]]--;
                if (hm[fruits[left]] == 0) {
                    hm.erase(fruits[left]);
                }
                ++left;
            }

            maxLen = max(maxLen, right - left + 1);
        }

        return maxLen;
    }
};