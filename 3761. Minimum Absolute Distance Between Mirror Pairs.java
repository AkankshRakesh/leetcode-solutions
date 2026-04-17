class Solution {
    public int rev(int num){
        int ans = 0;
        while(num != 0){
            ans *= 10;
            ans += num % 10;
            num /= 10;
        }

        return ans;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int rev = rev(nums[i]);
            // if(hm.containsKey(rev)){
            //     ans = Math.min(ans, i - hm.get(rev));
            // }
            if(hm.containsKey(nums[i])){
                ans = Math.min(ans, i - hm.get(nums[i]));
            }

            // hm.put(nums[i], i);
            hm.put(rev, i);
        }
        
        // for(int i = 0; i < nums.length; i++){
        //     int rev = rev(nums[i]);
        //     if(hm.containsKey(rev) && hm.get(rev) > i){
        //         ans = Math.min(ans, hm.get(rev) - i);
        //     }
        // }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}