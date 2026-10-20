class Solution {
public:
    int candy(vector<int>& ratings) {
        vector<vector<int>> nums(ratings.size(), vector<int>(2));

        for (int i = 0; i < ratings.size(); i++) {
            nums[i][0] = ratings[i];
            nums[i][1] = i;
        }

        sort(nums.begin(), nums.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        int least = nums[0][0];
        int index = 0;
        vector<int> candies(nums.size());

        while (index < nums.size() && nums[index][0] == least) {
            candies[nums[index++][1]] = 1;
        }

        while (index < nums.size()) {
            int curr = nums[index][0];

            while (index < nums.size() && nums[index][0] == curr) {
                int candyIndex = nums[index][1];
                int maxVal = 1;

                if (candyIndex > 0 && ratings[candyIndex - 1] < ratings[candyIndex])
                    maxVal = max(maxVal, candies[candyIndex - 1] + 1);

                if (candyIndex < nums.size() - 1 && ratings[candyIndex + 1] < ratings[candyIndex])
                    maxVal = max(maxVal, candies[candyIndex + 1] + 1);

                candies[candyIndex] = maxVal;
                index++;
            }
        }

        int sum = 0;
        for (int val : candies) sum += val;

        return sum;
    }
};