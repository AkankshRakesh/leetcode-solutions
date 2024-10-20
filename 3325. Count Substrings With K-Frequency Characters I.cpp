class Solution {
public:
    int numberOfSubstrings(string s, int k) {
        int totalSubstrings = 0;
    int n = s.length();
    
    for (int i = 0; i < n; ++i) {
        vector<int> freq(26, 0); 
        
        for (int j = i; j < n; ++j) {
            freq[s[j] - 'a']++; 
            
            for (int f = 0; f < 26; ++f) {
                if (freq[f] >= k) {
                    totalSubstrings++; 
                    break; 
                }
            }
        }
    }
    
    return totalSubstrings;
    }
};