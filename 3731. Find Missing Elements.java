class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int min = nums[0], max = nums[0];
        for(int num : nums){
            seen.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = min; i < max; i++){
            if(!seen.contains(i)) ans.add(i);
        }

        return ans;
    }
}