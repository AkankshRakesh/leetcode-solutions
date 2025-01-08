class Solution {
public:
    bool checkFromFirst(string main, string prefix){
        int n = main.length(), m = prefix.length();
        for(int i = 0, j = 0; i < n && j < m; i++, j++){
            if(main[i] != prefix[j]) return false;
        }
        return true;
    }
    bool checkFromLast(string main, string suffix){
        int n = main.length(), m = suffix.length();
        for(int i = n - 1, j = m - 1; i >= 0 && j >= 0; i--, j--){
            if(main[i] != suffix[j]) return false;
        }
        return true;
    }
    int countPrefixSuffixPairs(vector<string>& words) {
        int ans = 0;
        for(int i = 0; i < words.size(); i++){
            for(int j = i + 1; j < words.size(); j++){
                if(words[i].length() > words[j].length()) continue;
                if(checkFromLast(words[j], words[i]) && checkFromFirst(words[j], words[i])) ans++;
            }
        }
        return ans;
    }
};