class Solution {
public:
    int minOperations(vector<int>& nums) {
        int ans = 0;
        int n = nums.size();
        int max_val = 0;
       
        for(int x : nums) {
            max_val = max(max_val, x);
        }
       
        linSieve(max_val);
       
        for(int i = n - 2; i >= 0; i--) {
            while(nums[i] > nums[i + 1]) {
                if(nums[i] == lp[nums[i]]) return -1;
                nums[i] = lp[nums[i]];
                ans++;
            }
        }
       
        return ans;
    }


    vector<int> lp;
    vector<int> pr;


    void linSieve(int N) {
        lp.resize(N + 1);
        for(int i = 2; i <= N; i++) {
            if(lp[i] == 0) {
                lp[i] = i;
                pr.push_back(i);
            }
            for(int j = 0; j < pr.size() && i * pr[j] <= N; j++) {
                lp[i * pr[j]] = pr[j];
                if(pr[j] == lp[i]) break;
            }
        }
    }
};