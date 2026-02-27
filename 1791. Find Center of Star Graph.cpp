class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        vector<int> u = edges[0];
        vector<int> v = edges[1];

        if(u[0] == v[0] || u[0] == v[1]) return u[0];
        return u[1];
    }
};