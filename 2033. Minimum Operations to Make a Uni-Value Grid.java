class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                arr.add(grid[i][j]);
            }
        }

        Collections.sort(arr);
        int mid = arr.get(arr.size() / 2);
        int ans = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) > mid){
                if(((double)(arr.get(i) - mid) / x) != (arr.get(i) - mid) / x) return -1;
                ans += (arr.get(i) - mid) / x;
            }
            else{
                if(((double)(mid - arr.get(i)) / x) != (mid - arr.get(i)) / x) return -1;
                ans += (mid - arr.get(i)) / x;
            }
        }

        return ans;
    }
}