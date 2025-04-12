class Solution {
    public int minOperations(int[] nums, int k) {
        int tot = 0;
        for(int num : nums){
            tot += num;
        }

        if(tot % k  == 0) return 0;
        else return tot%k;
        
    }
}