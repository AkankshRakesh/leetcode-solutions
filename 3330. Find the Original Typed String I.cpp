class Solution {
public:
    int possibleStringCount(const std::string& word) {
        int ans = 1;
        char currChar = word[0];
        int currCount = 1;

        for (size_t i = 1; i < word.length(); i++) {
            if (word[i] == currChar) {
                currCount++;
            } else {
                ans += currCount - 1;
                currChar = word[i];
                currCount = 1;
            }
        }

        ans += currCount - 1;
        return ans;
    }
};
