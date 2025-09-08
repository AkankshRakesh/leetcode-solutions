class Solution {
public:
    static int distinct(vector<vector<int>>& matrix, int n) {
        unordered_map<int, int> hm;

        for (int i = 0; i < n; i++) {
            hm[matrix[0][i]]++;
        }

        for (int i = 1; i < n; i++) {
            unordered_map<int, int> currHm;
            for (int j = 0; j < n; j++) {
                if (hm.find(matrix[i][j]) == hm.end()) continue;

                if (hm[matrix[i][j]] == 1) hm.erase(matrix[i][j]);
                else hm[matrix[i][j]]--;

                currHm[matrix[i][j]]++;
            }
            hm = currHm;  
        }

        return (int)hm.size();
    }
};
