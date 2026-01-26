class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(arr.get(arr.size() - 1) < nums[i]) arr.add(nums[i]);
            else{
                int left = 0;
                int right = arr.size();
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if(arr.get(mid) >= nums[i]) right = mid;
                    else left = mid + 1;
                }
                if(left < arr.size()) arr.set(left, nums[i]);
            }
        }

        return arr.size();
    }
}