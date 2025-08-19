class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        fromLeft[0] = 0;
        fromRight[n - 1] = 0;

        int max = height[0];
        for(int i = 1; i < n; i++){
            if(height[i] > max){
                fromLeft[i] = 0;
                max = height[i];
            }
            else fromLeft[i] = max - height[i];
        }

        max = height[n - 1];
        for(int i = n - 1; i >= 0; i--){
            if(height[i] > max){
                fromRight[i] = 0;
                max = height[i];
            }
            else fromRight[i] = max - height[i];
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(fromLeft[i] == 0 || fromRight[i] == 0) continue;
            ans += Math.min(fromLeft[i], fromRight[i]);
        }

        return ans;
    }
}