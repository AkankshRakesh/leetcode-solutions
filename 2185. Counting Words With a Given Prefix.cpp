class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int n = pref.length(), ans = 0;
        for(int i = 0; i < words.size(); i++){
            if(words[i].length() >= n && words[i][0] == pref[0] && words[i][n - 1] == pref[n - 1]){
                string s = words[i];
                s.erase(n);
                if(s == pref) ans++;
            }
        }
        return ans;
    }
};