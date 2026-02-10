class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int weight : weights) right += weight;

        int ans = right;
        while(left < right){
            int mid = left + (right - left) / 2;
            int curr = 1;
            int sum = 0;
            for(int weight : weights){
                sum += weight;
                if(sum > mid){
                    sum = weight;
                    curr++;
                }
                if(weight > mid){
                    curr = days + 1;
                    break;
                }
            }

            if(curr <= days){
                right = mid;
                ans = mid;
            }
            else left = mid + 1;
        }

        return ans;
    }
}