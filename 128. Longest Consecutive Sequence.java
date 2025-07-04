class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<Integer>();

        for(int num : nums) hs.add(num);
        
        int maxCount = 1;
        for(int num : hs){
            if(!hs.contains(num - 1)){
                int count = 1;
                while(hs.contains(num + count)) count++;
                if(maxCount < count) maxCount = count;
            }
        }

        return maxCount;
    }
}