class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int max = nums[0];
        for(int num : nums) max = Math.max(max, num);

        int[] freq = new int[max + 1];
        for(int num : nums) freq[num]++;

        int[] sorted = new int[nums.length];
        int index = 0;
        for(int i = 0; i <= max; i++){
            int currFreq = freq[i];
            while(currFreq != 0){
                sorted[index] = i;
                index++;
                currFreq--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < sorted.length; i++){
            if(sorted[i] == target) ans.add(i);
        }

        return ans;
    }
}