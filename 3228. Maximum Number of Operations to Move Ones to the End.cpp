class Solution {
public:
    int maxOperations(string s) {
        int moves = 0;
        int n = s.size();
        int ones=0;
        bool flag = false;
        for(int i=0; i<n; ++i){
            if(s[i] == '1') {
                ones++;
                flag = true;
            }
            if(s[i] == '0' && flag){
                moves += ones;
                flag = false;
            }
        }
        return moves;
    }
};