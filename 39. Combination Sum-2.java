class Solution {
    public void dfs(int[] candidates, int index, List<List<Integer>> ans, List<Integer> curr, int currSum, int target, HashSet<String> hs, StringBuilder sb){
        if(currSum == target){
            if(hs.contains(sb.toString())) return;

            ans.add(new ArrayList<>(curr));
            hs.add(new String(sb.toString()));
            return;
        }
        if(index >= candidates.length || currSum > target) return;

        curr.add(candidates[index]);
        int len = sb.length();
        sb.append(candidates[index] + "#");
        dfs(candidates, index, ans, curr, currSum + candidates[index], target, hs, sb);
        dfs(candidates, index + 1, ans, curr, currSum + candidates[index], target, hs, sb);

        sb.delete(len, sb.length());
        curr.remove(curr.size() - 1);
        dfs(candidates, index + 1, ans, curr, currSum, target, hs, sb);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, 0, ans, new ArrayList<>(), 0, target, new HashSet<>(), new StringBuilder());

        return ans;
    }
}