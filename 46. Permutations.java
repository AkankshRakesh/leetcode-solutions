class Solution {
    public void backtrack(List<List<Integer>> ans, List<Integer> arr, int[] nums, int index, HashSet<Integer> added){
        if(index >= nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(added.contains(nums[i])) continue;
            arr.add(nums[i]);
            added.add(nums[i]);
            backtrack(ans, arr, nums, index + 1, added);
            arr.remove(arr.size() - 1);
            added.remove(nums[i]);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> added = new HashSet<>();
        backtrack(ans, new ArrayList<>(), nums, 0, added);

        return ans;
    }
}