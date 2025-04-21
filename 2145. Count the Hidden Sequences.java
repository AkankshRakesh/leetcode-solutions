class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int x = 0, y = 0, curr = 0;
        for(int num : differences){
            curr += num;
            x = curr > x ? x : curr;
            y = curr > y ? curr : y;
            if(y - x > upper - lower) return 0;
        }
        return (upper - lower) - (y - x) + 1;
    }
}