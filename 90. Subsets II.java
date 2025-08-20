class Solution {
    public void backtrack(int[] nums, List<List<Integer>> res, int ind, ArrayList<Integer> currArr, HashSet<ArrayList<Integer>> hs){
        if(ind >= nums.length){
            if(hs.contains(currArr)) return;
            hs.add(currArr);
            res.add(new ArrayList<>(currArr));
            return;
        }

        currArr.add(nums[ind]);
        backtrack(nums, res, ind + 1, currArr, hs);
        
        currArr.remove(currArr.size() - 1);
        backtrack(nums, res, ind + 1, currArr, hs);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            if(i == 0 || (i > 0 && nums[i - 1] != nums[i])){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                backtrack(nums, res, i + 1, temp, hs);
            }
        }

        return res;
    }
}