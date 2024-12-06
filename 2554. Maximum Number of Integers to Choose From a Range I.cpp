class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        sort(banned.begin(), banned.end());
        int j = 0, ans = 0, len = banned.size(), currSum = 0;
        for(int i = 1; i <= n; i++){
            while(j < len && banned[j] < i) j++;
            if(j < len && banned[j] == i) continue;
            else if(currSum + i > maxSum) break;
            else{
                ans++;
                currSum += i;
            }
        }
        return ans;
    }
};