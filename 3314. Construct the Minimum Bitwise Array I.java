class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        Arrays.fill(ans, -1);
        int index = 0;

        for(int num : nums){
            for(int i = 1; i < num; i++){
                int val = i + 1;
                val |= i;
                if(val == num){
                    ans[index] = i;
                    break;
                }
            }
            index++;
        }

        return ans;
    }
} 