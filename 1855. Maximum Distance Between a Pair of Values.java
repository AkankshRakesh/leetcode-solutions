class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = Integer.MIN_VALUE;
        int n = nums1.length, m = nums2.length;
        for(int i = 0; i < n; i++){
            if(i >= m) break;
            int left = i, right = m - 1;
            int currAns = -1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums2[mid] >= nums1[i]){
                    currAns = mid;
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }

            if(currAns != -1) ans = Math.max(ans, currAns - i);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}