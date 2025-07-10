class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        int n = costs.size();
        int maxEle = *max_element(costs.begin(), costs.end());

        vector<int> countArr(maxEle + 1, 0);

        for (int i = 0; i < n; i++) {
            countArr[costs[i]]++;
        }

        for (int i = 1; i <= maxEle; i++) {
            countArr[i] += countArr[i - 1];
        }

        vector<int> sortedArr(n);
        for (int i = n - 1; i >= 0; i--) {
            sortedArr[countArr[costs[i]] - 1] = costs[i];
            countArr[costs[i]]--;
        }

        int ans = 0;
        int costCount = 0;
        for (int i = 0; i < n; i++) {
            if (costCount + sortedArr[i] > coins) return ans;
            costCount += sortedArr[i];
            ans++;
        }

        return ans;
    }
};
