class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temp) {
        int n = temp.size();
        vector<int> tempInd(71, 0);
        vector<int> ans(n, 0);

        tempInd[temp[n - 1] - 30] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            int currTemp = temp[i] - 30;
            int higherTempInd = n;
            for (int j = currTemp + 1; j <= 70; j++) {
                if (tempInd[j] != 0)
                    higherTempInd = min(tempInd[j], higherTempInd);
            }
            tempInd[currTemp] = i;

            if (higherTempInd != n)
                ans[i] = higherTempInd - i;
        }

        return ans;
    }
};