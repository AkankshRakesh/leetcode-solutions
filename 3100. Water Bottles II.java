class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = 0, drunk = 0;
        empty = numBottles;
        drunk += numBottles;
        numBottles = 0;
        while(empty >= numExchange){
            numBottles++;
            empty -= numExchange;
            numExchange++;
            if(empty < numExchange){
                drunk += numBottles;
                empty += numBottles;
                numBottles = 0;
            }
        }

        return drunk;
    }
}