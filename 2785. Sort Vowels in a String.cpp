class Solution {
public:
    bool isVowel(char ch) {
        switch (ch) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
            case 'A': case 'E': case 'I': case 'O': case 'U':
                return true;
            default:
                return false;
        }
    }

    string sortVowels(string s) {
        map<char, int> tm; 
        for (char c : s) {
            if (isVowel(c)) tm[c]++; 
        }

        string result = s;
        for (int i = 0; i < (int)s.size(); i++) {
            if (!isVowel(s[i])) continue;

            auto it = tm.begin();        // smallest vowel
            char ch = it->first;
            int count = it->second;

            result[i] = ch;

            if (count == 1) tm.erase(it);
            else it->second--;
        }

        return result;
    }
};
