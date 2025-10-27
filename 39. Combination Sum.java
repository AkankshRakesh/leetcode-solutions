class Solution {
    HashSet<List<Integer>> hs = new HashSet<>();
    public void backtrack(int[] candidates, int index, int target, List<Integer> curr, int currSum){
        if(currSum == target){
            hs.add(new ArrayList<>(curr));
            return;
        }
        if(currSum > target || index >= candidates.length) return;

        curr.add(candidates[index]);
        backtrack(candidates, index, target, curr, currSum + candidates[index]);
        curr.remove(curr.size() - 1);
        
        backtrack(candidates, index + 1, target, curr, currSum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<Integer>(), 0);

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> arr : hs) ans.add(arr);

        return ans;
    }
}