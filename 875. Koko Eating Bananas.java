class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = piles[0];

        for(int pile : piles) if(maxPile < pile) maxPile = pile;
        
        if(h == n) return maxPile;
        int left = 1, right = maxPile, minSpeed = maxPile;
        while(left < right){
            int mid = left + (right - left)/2;

            int time = 0;
            for(int pile : piles){
                time += (pile + mid - 1) / mid;
            }
            if(time > h) left = mid + 1;
            else{
                minSpeed = mid;
                right = mid;
            }
        }
        return minSpeed;


    }
}