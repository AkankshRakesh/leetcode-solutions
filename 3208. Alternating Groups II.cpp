class Solution {
public:
    int numberOfAlternatingGroups(const vector<int>& colors, int k) {
        int left = 0, right = 0;
        unordered_set<int> badIndexes;
        for (right = 1; right < k; right++) {
            if (colors[right] == colors[right - 1]) badIndexes.insert(right - 1);
        }
        int ans = 0;
        for (left = 0; left < (int)colors.size(); left++) {
            if (badIndexes.empty()) ans++;
            if (badIndexes.count(left)) badIndexes.erase(left);

            int modRight = right % (int)colors.size();
            int modPrevRight = modRight != 0 ? modRight - 1 : (int)colors.size() - 1;
            if (colors[modPrevRight] == colors[modRight]) badIndexes.insert(modRight - 1);
            right++;
        }
        return ans;
    }
};