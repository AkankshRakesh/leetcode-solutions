class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int min = -1;
        for(int i = 0; i < n; i++){
            int first = nums[i];
            for(int j = i + 1; j < n; j++){
                int second = nums[j];
                if(first >= second) continue;
                
                if(second - first > min) min = second - first;
            }
        }
        return min;
    }
}