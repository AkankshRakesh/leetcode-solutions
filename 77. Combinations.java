class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void backtrack(int n, int curr, List<Integer> currArr, int k){
        if(currArr.size() == k){
            ans.add(new ArrayList<>(currArr));
            return;
        }
        for(int i = curr + 1; i <= n; i++){
            currArr.add(i);
            backtrack(n, i, currArr, k);
            currArr.remove(currArr.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        for(int i = 1; i <= n; i++){
            List<Integer> currArr = new ArrayList<>();
            currArr.add(i);
            backtrack(n, i, currArr, k);
        }

        return ans;
    }
}