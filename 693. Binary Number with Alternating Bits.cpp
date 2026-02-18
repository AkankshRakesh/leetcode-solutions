class Solution {
public:
    bool hasAlternatingBits(int n) {
        int flag = n & 1;
        n = n >> 1;
        while(n != 0){
            if((n & 1) == flag) return false;
            flag = n & 1;
            n = n >> 1;
        }
        return true;
    }
};