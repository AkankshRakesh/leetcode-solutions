class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        int bitStore = 0;
        for(int num : nums){
            if(num % original == 0){
                int div = num / original;
                if((div & (div - 1)) == 0){
                    bitStore |= div;
                }
            }
        }

        int ind = 0;
        while(true){
            if((bitStore & 1) == 0) break;
            bitStore >>= 1;
            ind++;
        }

        return (1 << ind) * original;
    }
};
