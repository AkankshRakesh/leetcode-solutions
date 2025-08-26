class Solution {
    public void recursion(int[] nums, boolean[] visited, ArrayList<Integer> curr, List<List<Integer>> ans, int n){
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            curr.add(nums[i]);
            visited[i] = true;
            recursion(nums, visited, curr, ans, n);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
        if(curr.size() != n) return;
        ans.add(new ArrayList<>(curr));
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(); 

        for(int i = 0; i < n; i++){
            visited[i] = true;
            temp.add(nums[i]);
            recursion(nums, visited, temp, ans, n);
            temp.remove(temp.size() - 1);    
            visited[i] = false;
        }

        return ans;
    }
}