class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        for(int i = 0; i + k <= nums.length; i++){
            boolean[] found = new boolean[51];
            for(int j = i; j < i + k; j++){
                // System.out.print(nums[j] + " ");
                if(!found[nums[j]]) freq[nums[j]]++;
                found[nums[j]] = true;
            }
            // System.out.println();
        }

        int ans = -1;
        for(int i = 0; i <= 50; i++){
            if(freq[i] == 1) ans = i;
        }

        return ans;
    }
}