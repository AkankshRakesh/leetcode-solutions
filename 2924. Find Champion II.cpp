class Solution {
public:
    int findChampion(int n, vector<vector<int>>& edges) {
        vector<int> deg(n, 0), inDegree0;
        for(auto edge : edges){
            int weight = edge[1];
            deg[weight]++;
        }
        for(int i = 0; i < n; i++){
            if(deg[i] == 0) inDegree0.push_back(i);
        }
        if(inDegree0.size() != 1) return -1;
        return inDegree0[0];
    }
};