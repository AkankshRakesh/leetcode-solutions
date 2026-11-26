class Solution {
public:
    bool canAliceWin(int n) {
        if(n < 10) return false;
        else if(n < 19) return true;
        else if(n < 27) return false;
        else if(n < 34) return true;
        else if (n < 40) return false;
        else if(n < 45) return true;
        else if(n < 49) return false;

        return true;
    }
};