class Solution {
    public void backtrack(int[] nums, int index, ArrayList<Integer> currArr, List<List<Integer>> arr, int n, HashSet<ArrayList<Integer>> hs){
        if(index == n){
            if(!hs.contains(currArr)){
                arr.add(new ArrayList<>(currArr));
                hs.add(new ArrayList<>(currArr));
            }
            return;
        }

        currArr.add(nums[index]);
        backtrack(nums, index + 1, currArr, arr, n, hs);
        currArr.remove(currArr.size() - 1);
        backtrack(nums, index + 1, currArr, arr, n, hs);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<Integer>(), arr, nums.length, hs);
        return arr;
    }
}