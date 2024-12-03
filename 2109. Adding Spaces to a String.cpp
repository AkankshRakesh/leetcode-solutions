class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        string ans = "";
        int ind = spaces[0] - 1, nextInd = 0, n = spaces.size();
        if(ind == -1){
            ans += ' ';
            nextInd++;
            if(nextInd < n)ind = spaces[nextInd] - 1;
        }
        for(int i = 0; i < s.size(); i++){
            ans += s[i];
            if(ind == i){
                ans += ' ';
                nextInd++;
                if(nextInd < n)ind = spaces[nextInd] - 1;
            }
        }
        return ans;
    }
};