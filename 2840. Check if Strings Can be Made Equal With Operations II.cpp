class Solution {
public:
    bool checkStrings(const string& s1, const string& s2) {
        vector<int> freqOddS1(26, 0);
        vector<int> freqOddS2(26, 0);
        vector<int> freqEvenS1(26, 0);
        vector<int> freqEvenS2(26, 0);

        for (size_t i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                freqEvenS1[s1[i] - 'a']++;
                freqEvenS2[s2[i] - 'a']++;
            } else {
                freqOddS1[s1[i] - 'a']++;
                freqOddS2[s2[i] - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freqOddS1[i] != freqOddS2[i] || freqEvenS1[i] != freqEvenS2[i]) return false;
        }

        return true;
    }
};