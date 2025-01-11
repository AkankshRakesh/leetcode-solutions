class Solution {
public:
    bool canConstruct(string s, int k) {
        int n = s.length();
        if(n < k) return false;
        else if(n == k) return true;
        vector<int> numArr(26, 0);
        for(int i = 0; i < n; i++){
            numArr[s[i] - 'a']++;
        }
        int odd = 0;
        for(int i = 0; i < 26; i++){
            if(numArr[i] % 2 != 0) odd++;
        }
        if(odd > k) return false;
        return true;
    }
};