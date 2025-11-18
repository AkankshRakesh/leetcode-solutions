class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        int ind = 0;
        while (ind < bits.size()) {
            if (bits[ind] == 0) {
                ind++;
                if (ind == bits.size()) return true;
            } else {
                ind += 2;
                if (ind >= bits.size()) return false;
            }
        }
        return false;
    }
};
