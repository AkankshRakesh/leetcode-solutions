class Solution {
    public int differenceOfSums(int n, int m) {
        int nonDiv = 0, div = 0;
        for(int i = 1; i <= n; i++){
            if(i < m) nonDiv += i;
            else{
                if(i % m == 0) div += i;
                else nonDiv += i;
            }
        }
        return nonDiv - div;
    }
}