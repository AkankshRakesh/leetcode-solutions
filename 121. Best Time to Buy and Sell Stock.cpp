class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = INT_MAX;
        int profit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            profit = max(profit, price - minPrice);
        }

        return profit;
    }
};
