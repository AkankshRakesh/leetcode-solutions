class Solution {
    public String[] createGrid(int n, int m) {
        String[] ans = new String[n];
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(".");
            if(i == n - 1) for(int j = 1; j < m; j++) sb.append(".");
            else for(int j = 1; j < m; j++) sb.append("#");
            
            ans[i] = sb.toString();
        }

        return ans;
    }
}