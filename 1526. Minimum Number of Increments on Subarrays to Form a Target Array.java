class Solution {
    public int minNumberOperations(int[] target) {
        int prev = 0;
        int ans = 0;
        for(int height : target){
            if(height > prev){
                ans += height - prev;
            }
            prev = height;
        }

        return ans;
    }
}