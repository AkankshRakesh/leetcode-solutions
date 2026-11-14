class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            int left = 0;
            int sum = 0;
            for(int j = 0; j < i; j++) sum += nums.get(j);

            for(int j = i; j < nums.size(); j++){
                if(sum > 0) ans = Math.min(ans, sum);
                // System.out.println(sum + " " + i);
                sum -= nums.get(left);
                left++;
                sum += nums.get(j);
            }

            if(sum > 0) ans = Math.min(ans, sum);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}