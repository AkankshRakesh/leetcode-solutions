class Solution {
public:
    bool isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    bool isNum(char c) {
        return c >= '0' && c <= '9';
    }

    bool isValid(string word) {
        bool vowel = false, consonant = false;
        if (word.length() < 3) return false;

        for (char& c : word) {
            c = tolower(c);
            if (isVowel(c)) vowel = true;
            else if (isalpha(c)) consonant = true;
            else if (!isNum(c)) return false;
        }

        return vowel && consonant;
    }
};
