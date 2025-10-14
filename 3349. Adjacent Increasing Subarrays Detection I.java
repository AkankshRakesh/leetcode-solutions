class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] hasSub = new boolean[n];
        int c = 1;
        if(k == 1) hasSub[0] = true;
        for(int i = 1; i < n; i++){
            if(nums.get(i) > nums.get(i - 1)) c++;
            else c = 1;

            if(c >= k) hasSub[i] = true;
        }

        for(int i = 0; i < n; i++){
            // System.out.println(hasSub[i]);
            if(hasSub[i] && i + k < n && hasSub[i + k]) return true;
        }

        return false;
    }
}