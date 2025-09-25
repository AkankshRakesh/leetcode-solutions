class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int n = triangle.size();
        for(int i = n - 2; i >= 0; i--){
            int m = triangle.get(i).size();
            for(int j = 0; j < m; j++){
                int left = triangle.get(i + 1).get(j);
                int right = triangle.get(i + 1).get(j + 1);
                int curr = triangle.get(i).get(j);
                triangle.get(i).set(j, Math.min(curr + left, curr + right));
            }
        }

        return triangle.get(0).get(0);
    }
}