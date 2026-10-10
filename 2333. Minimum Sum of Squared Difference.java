class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int maxDiff = Math.abs(nums1[0] - nums2[0]);
        for(int i = 0; i < nums1.length; i++){
            maxDiff = Math.max(maxDiff, Math.abs(nums1[i] - nums2[i]));
        }

        int[] freq = new int[maxDiff + 1];
        for(int i = 0; i < nums1.length; i++){
            freq[Math.abs(nums1[i] - nums2[i])]++;
        }

        long k = (long)k1 + (long)k2;
        
        int index = maxDiff;
        while(index > 0 && k != 0){
            if(freq[index] > k){
                freq[index - 1] += k;
                freq[index] -= k;
                k = 0;
            }
            else{
                freq[index - 1] += freq[index];
                k -= freq[index];
                freq[index] = 0;
            }
            index--;
        }

        long ans = 0;
        for(int i = 1; i <= maxDiff; i++){
            ans += (long) i * i * freq[i];
        }

        return ans;
    }
}