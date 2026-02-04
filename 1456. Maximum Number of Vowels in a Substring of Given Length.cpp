class Solution {
public:
    bool isVowel(char ch) {
        switch(ch) {
            case 'a': 
            case 'e': 
            case 'i': 
            case 'o': 
            case 'u': 
                return true;
            default:
                return false;
        }
    }

    int maxVowels(const std::string& s, int k) {
        int count = 0;
        for(int i = 0; i < k; i++) {
            if(isVowel(s[i])) count++;
        }

        int ans = count;
        for(int i = k; i < (int)s.length(); i++) {
            if(isVowel(s[i - k])) count--;
            if(isVowel(s[i])) count++;

            ans = std::max(ans, count);
        }

        return ans;
    }
};