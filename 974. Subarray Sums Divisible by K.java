class Solution {
    // 10:36
    public int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k];
        freq[0]++;
        int sum = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            ans += freq[(sum % k + k) % k];

            freq[(sum % k + k) % k]++;
        } 

        return ans;
    }
}