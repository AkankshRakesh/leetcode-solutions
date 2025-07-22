class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;
        int left = 0;
        int maxScore = Integer.MIN_VALUE;
        int score = nums[0];
        hs.add(nums[0]);

        for(int right = 1; right < n; right++){
            int currEle = nums[right];
            while(hs.contains(currEle) && left < right){
                score -= nums[left];
                hs.remove(nums[left]);
                // System.out.println(nums[left]);
                left++;
            }
            score += currEle;
            hs.add(currEle);
            if(score > maxScore) maxScore = score;
        }
        if(score > maxScore) maxScore = score;
        return maxScore;
    }
}