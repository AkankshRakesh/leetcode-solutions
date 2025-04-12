class Solution {
    public:
        int uniqueXorTriplets(vector<int>& nums) {
            vector<int> gl = nums;
            const int MAX_VAL = 2047;
            vector<bool> present(MAX_VAL + 1, false);
    
            for(int x : gl){
                present[x] = true;
            }
    
            vector<int> D;
            for(int val = 1; val <= MAX_VAL; val++){
                if(present[val]){
                    D.push_back(val);
                    
                }
            }
            if(D.empty()) return 0;
            vector<bool> pairVal(MAX_VAL + 1, false);
            for(int x : D){
                for(int y : D){
                    pairVal[x ^ y] = true;
                }
            }
    
            vector<bool> possible(MAX_VAL + 1, false);
    
            for(int x : D){
                possible[x] = true;
            }
    
            for(int p = 0; p <= MAX_VAL; p++){
                if(!pairVal[p]) continue;
    
                for(int z : D){
                    int val = p ^ z;
                    possible[val] = true;
                }
            }
            int ans = 0;
            for(int v = 0; v <= MAX_VAL; v++){
                if(possible[v]) ans++;
            }
            return ans;
            
        }
    };