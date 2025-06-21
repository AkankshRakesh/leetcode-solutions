class Solution {
public:
    int minimumDeletions(string word, int k) {
        vector<int> freqTable(26, 0);
        int n = word.length();

        for (int i = 0; i < n; i++) {
            freqTable[word[i] - 'a']++;
        }

        int minDeletions = INT_MAX;
        for (int i = 0; i < 26; i++) {
            if (freqTable[i] == 0) continue;

            int upperRange = freqTable[i] + k;
            int deleted = 0;

            for (int j = 0; j < 26; j++) {
                if (i == j) continue;
                if (freqTable[j] < freqTable[i]) {
                    deleted += freqTable[j];
                } else if (freqTable[j] > upperRange) {
                    deleted += (freqTable[j] - upperRange);
                }
            }

            minDeletions = min(minDeletions, deleted);
        }

        return minDeletions;
    }
};
