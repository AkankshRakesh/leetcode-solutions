class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int poss = maxWeight / w;
        if(poss > n*n){
            return n*n;
        }
        return poss;
    }
}