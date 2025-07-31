class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){
            if(height[left] > height[right]){
                int area = height[right] * (right - left);
                if(area > maxArea) maxArea = area;
                right--;
            }
            else{
                int area = height[left] * (right - left);
                if(area > maxArea) maxArea = area;
                left++;
            }
        }

        return maxArea;
    } 
}