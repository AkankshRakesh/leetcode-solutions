class Solution {
    public boolean canShip(int[] nums, int days, int w){
        int index = 0;
        int curr = 0;
        while(index < nums.length && days > 0){
            if(curr + nums[index] > w){
                days--;
                curr = 0;
            }
            else{
                curr += nums[index];
                index++;
            }
        }

        if(days <= 0) return false;
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int min = weights[0];
        for(int weight : weights){
            sum += weight;
            min = Math.min(min, weight);
        }

        int left = min, right = sum;
        int ans = right;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canShip(weights, days, mid)){
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return ans;
    }
}