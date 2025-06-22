class Solution {
    public void backtrack(int ind, List<Integer> tempList ,List<List<Integer>> res, int[] candidates, int total, int n){
        if(total < 0) return;
        else if(total == 0){
            res.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = ind; i < n && total >= candidates[i]; i++){
                if(i > ind && candidates[i] == candidates[i - 1]) continue;
                tempList.add(candidates[i]);
                backtrack(i + 1, tempList, res, candidates, total - candidates[i], n);
                tempList.remove(tempList.size() - 1); 
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<Integer>(), ans, candidates, target, candidates.length);
        return ans;
    }
}