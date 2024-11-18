class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        bool pos = false;
        if(k < 0){
            pos = true;
            k = 0 - k;
        }
        int n = code.size();
        vector<int> res(n,0);
        
        if(k == 0) return res;
        for(int i = 0; i < n; i++){
            int sum = 0;
            if(!pos){
                for(int j = 1; j <= k; j++){
                    sum += code[(i + j) % n];
                }
            }
            else{
                for(int j = 1; j <= k; j++){
                    sum += code[(i - j + n) % n]; 
                }
            }
            res[i] = sum;
        }
        return res;
    }
};