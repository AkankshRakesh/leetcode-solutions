class Solution {
public:
    int numWaterBottles(int numBottles, int rate) {
        int extraEmpty = 0;
        int drinks = 0;
        while(numBottles){
            drinks += numBottles;
            numBottles += extraEmpty;
            extraEmpty = numBottles % rate;
            numBottles /= rate;
        }
        return drinks;
    }
};