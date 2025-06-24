class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] arr = new boolean[n];

        for(int i = 0; i < n; i++){
            if(nums[i] == key){
                int startInd = i - k >= 0 ? i - k : 0;
                int endInd = i + k < n ? i + k : n - 1;

                for(int j = startInd; j <= endInd; j++) arr[j] = true;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(arr[i]) ans.add(i);
        }

        return ans;
    }
}