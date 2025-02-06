class Solution {
public:
    long nCr(int n, int r)
    {
        return fact(n) / (fact(r) * fact(n - r));
    }

    long fact(int n)
    {
        if(n==0)
        return 1;
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
    int tupleSameProduct(vector<int>& nums) {
        vector<int> ans;
        int count = 0;
        for(int i = 0; i < nums.size(); i++){
            for(int j = i + 1; j < nums.size(); j++){
                int product = nums[i] * nums[j];
                ans.push_back(product);
            }
        }
        sort(ans.begin(), ans.end());
        int stored = ans[0], tempCount = 1;
        for(int i = 1; i < ans.size(); i++){
            if(stored == ans[i]) tempCount++;
            else{
                if(tempCount > 1){
                    count += nCr(tempCount, 2);
                }
                tempCount = 1;
                stored = ans[i];
            }
        }
        return count * 8; 
    }
};