class Solution {
    public void backtrack(List<List<Integer>> ans, HashSet<ArrayList<Integer>> hs, int currEle, ArrayList<Integer> currArr, int currSum, int sum, int count, int maxCount){
        if(currSum > sum || count > maxCount) return;
        if(currEle > 9 || (currSum == sum && count == maxCount)){
            if(currSum == sum && count == maxCount){
                if(hs.contains(currArr)) return;
                hs.add(new ArrayList<>(currArr));
                ans.add(new ArrayList<>(currArr));
            }
            return;
        }
        currArr.add(currEle);
        backtrack(ans, hs, currEle + 1, currArr, currSum + currEle, sum, count + 1, maxCount);

        currArr.remove(currArr.size() - 1);
        backtrack(ans, hs, currEle + 1, currArr, currSum, sum, count, maxCount);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();

        backtrack(ans, hs, 1, new ArrayList<>(),0, n, 0, k);
        
        return ans;
    }
}