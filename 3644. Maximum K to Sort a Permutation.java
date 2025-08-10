class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int swapCost = ~0;
        boolean[] visited = new boolean[n];
        boolean found = false;
        
        for(int i = 0; i < n; i++){
            if(!visited[i] && nums[i] != i){
                found = true;
                int andFound = ~0;
                int curr = i;
                while(!visited[curr]){
                    visited[curr] = true;
                    andFound &= nums[curr];
                    curr = nums[curr];
                }

                swapCost &= andFound;
            }
        }

        return found ? swapCost : 0;
    }
}