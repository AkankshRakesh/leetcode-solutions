class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int maxSize = 0;

        while (left < right) {
            int dist = right - left;
            if (height[left] < height[right]) {
                maxSize = max(maxSize, height[left] * dist);
                left++;
            } else { 
                maxSize = max(maxSize, height[right] * dist);
                right--;
            }
        }
        return maxSize;
    }
}; 
