class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        int m = mat.size();  
        int n = mat[0].size(); 
        int size = arr.size();
        
        vector<int> rowTrack(m, 0), colTrack(n, 0);
        
        unordered_map<int, pair<int, int>> map;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[mat[i][j]] = {i, j};
            }
        }
        
        for (int i = 0; i < size; i++) {
            auto [r, c] = map[arr[i]]; 
            rowTrack[r]++;            
            colTrack[c]++;        
            
            if (rowTrack[r] == n || colTrack[c] == m) {
                return i; 
            }
        }
        
        return -1; 
    }
};
