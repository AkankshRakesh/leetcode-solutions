class Solution {
    public long dfs(ArrayList<Integer> arr, long[][] table){
        int n = arr.size();
        if(n < 3) return 1;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(arr.get(i) < arr.get(0)) left.add(arr.get(i));
            else right.add(arr.get(i));
        }

        long leftCount = dfs(left, table);
        long rightCount = dfs(right, table);

        long ans = (leftCount * rightCount) % 1_000_000_007;
        ans = (ans * table[n - 1][left.size()]) % 1_000_000_007;

        return ans;
    }
    public int numOfWays(int[] nums) {
        int n = nums.length; 

        long[][] table = new long[n][n];
        for (int i = 0; i < n; ++i) {
            table[i][0] = table[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % 1_000_000_007;
            }
        }


        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums) arr.add(num);

        return (int)((dfs(arr, table) - 1) % 1_000_000_007);
    }
}