class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int leftInd = -1;
        int rightInd = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                leftInd = i - 1;
                break;
            }
        }
        if(leftInd == -1) return 0;
        for(int i = nums.length - 2; i >= leftInd; i--){
            if(nums[i] > nums[i + 1]){
                rightInd = i + 1;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = leftInd; i <= rightInd; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }


        for(int i = leftInd - 1; i >= 0; i--){
            if(nums[i] > min){
                leftInd = i;
                max = Math.max(max, nums[i]);
            }
        }
        for(int i = rightInd + 1; i < nums.length; i++){
            if(nums[i] < max){
                rightInd = i;
                min = Math.min(min, nums[i]);
            }
        }

        return rightInd - leftInd + 1;
    }
}