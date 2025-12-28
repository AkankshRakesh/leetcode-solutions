class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            int a = nums[i];
            if(hs.contains(a)) continue;
            int left = i + 1;
            int right = n - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] == k + a){
                    // hs.add(nums[mid]);
                    hs.add(a);
                    ans++;
                    break;
                }
                else if(nums[mid] > k + a) right = mid - 1;
                else left = mid + 1;
            }
        }

        return ans;
    }
}