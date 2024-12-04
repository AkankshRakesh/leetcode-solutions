class Solution {
public:
    bool canMakeSubsequence(string str1, string str2) {
        int ind = 0, n = str2.length();
        for(int i = 0; i < str1.length(); i++){
            if(ind < n && str1[i] == str2[ind]){
                ind++;
                continue;
            }
            if(str1[i] == 'z'){
                str1[i] = 'a';
            }
            else{
                str1[i] = str1[i] + 1;
            }
            if(ind < n && str1[i] == str2[ind]) ind++;
        }
        if(ind == n) return true;
        return false;
    }
};