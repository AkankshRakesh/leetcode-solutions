class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(area, ans);
            if(height[left] < height[right]) left++;
            else right--;
        }

        return ans;
    }
} 