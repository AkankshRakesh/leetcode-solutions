class Solution {
    public int calcProd(int[] nums, int negCount, int left, int right){
        if(negCount % 2 == 0){
            int prod = 0;
            for(int i = left; i < right; i++){
                if(prod == 0) prod = nums[i];
                else prod *= nums[i];
            }
            return prod;
        }

        int firstNeg = -1;
        int prod = 0;
        for(int i = left; i < right; i++){
            if(nums[i] < 0){
                negCount--;
                if(firstNeg == -1) firstNeg = i;
                if(negCount == 0) break;
            }
            if(prod == 0) prod = nums[i];
            else prod *= nums[i];
        }
        int prod2 = 0;
        for(int i = firstNeg + 1; i < right; i++){
            if(prod2 == 0) prod2 = nums[i];
            else prod2 *= nums[i];
        }

        return Math.max(prod, prod2);
    }
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];

        int negCount = 0, last = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num < 0) negCount++;
            else if(num == 0){
                ans = Math.max(ans, calcProd(nums, negCount, last, i));
                last = i + 1;
                negCount = 0;
            }
        }
        
        ans = Math.max(ans, calcProd(nums, negCount, last, nums.length));

        return ans;
    }
}