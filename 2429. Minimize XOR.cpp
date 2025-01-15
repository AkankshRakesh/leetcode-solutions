class Solution {
public:
    bool isSet(int x, int bit) { return x & (1 << bit); }
    void setBit(int &x, int bit) { x |= (1 << bit); }
    void unsetBit(int &x, int bit) { x &= ~(1 << bit); }
    int minimizeXor(int num1, int num2) {
        int result = num1;

        int targetSetCount = __builtin_popcount(num2);
        int setCount = __builtin_popcount(result);
        int currBit = 0;

        while(setCount < targetSetCount){
            if(!isSet(result, currBit)){
                setBit(result, currBit);
                setCount++;
            }
            currBit++;
        }

        while(setCount > targetSetCount){
            if(isSet(result, currBit)){
                unsetBit(result, currBit);
                setCount--;
            }
            currBit++;
        }
        return result;
    }
};