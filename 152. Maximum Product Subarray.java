class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int minProd = 1;
        int maxProd = 1;

        for(int num : nums){
            minProd *= num;
            maxProd *= num;
            res = Math.max(res, Math.max(minProd, maxProd));
            if(num == 0){
                minProd = 1;
                maxProd = 1;
            }
            else if(maxProd < 0) maxProd = 1;
        }
        minProd = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            minProd *= nums[i];
            res = Math.max(res, minProd);
            if(nums[i] == 0) minProd = 1;
        }

        return res;
    }
}