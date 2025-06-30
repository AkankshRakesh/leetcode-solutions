class Solution {
    public void takeLeave(int ind, ArrayList<List<Integer>> arr, ArrayList<Integer> subArr, int n, int[] nums){
        if(ind >= n){
            arr.add(new ArrayList<>(subArr));
            return;
        }

        subArr.add(nums[ind]);
        takeLeave(ind + 1, arr, subArr, n, nums);
        subArr.remove(subArr.size() - 1);
        takeLeave(ind + 1, arr, subArr, n, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> arr = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<>();
        takeLeave(0, arr, temp, nums.length, nums);
        return arr;
    }
}