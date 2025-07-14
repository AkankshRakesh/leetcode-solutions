class Solution {
    public void backtrack(int[] nums, int index, int n, List<List<Integer>> arr, ArrayList<Integer> currArr, HashSet<ArrayList<Integer>> hs){
        if(index >= n){
            if(currArr.size() >= 2 && !hs.contains(currArr)){
                arr.add(new ArrayList<Integer>(currArr));
                hs.add(new ArrayList<Integer>(currArr));
            }
            return;
        }

        int size = currArr.size();
        if(size >= 1){
            if(currArr.get(size - 1) <= nums[index]){
                currArr.add(nums[index]);
                backtrack(nums, index + 1, n, arr, currArr, hs);
                currArr.remove(size);
            }
            backtrack(nums, index + 1, n, arr, currArr, hs);
        }
        else{
            currArr.add(nums[index]);
            backtrack(nums, index + 1, n, arr, currArr, hs);
            currArr.remove(0);
            backtrack(nums, index + 1, n, arr, currArr, hs);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        backtrack(nums, 0, nums.length, arr, new ArrayList<Integer>(), hs);

        return arr;
    }
}