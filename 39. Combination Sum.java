class Solution {
    public void backtrack(int[] candidates, int target, List<List<Integer>> arr, int index, int n, int currSum, ArrayList<Integer> currArr){
        if(index == n){
            if(currSum == target){
                arr.add(new ArrayList<>(currArr));
            }
            return;
        }

        if(currSum == target){
            arr.add(new ArrayList<>(currArr));
            return;
        }

        if(currSum + candidates[index] > target) return;
        currArr.add(candidates[index]);
        backtrack(candidates, target, arr, index, n, currSum + candidates[index], currArr);
        currArr.remove(currArr.size() - 1);
        backtrack(candidates, target, arr, index + 1, n, currSum, currArr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        backtrack(candidates, target, arr, 0, candidates.length, 0, new ArrayList<>());
        return arr;
    }
}