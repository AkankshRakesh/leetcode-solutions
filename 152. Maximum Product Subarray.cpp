class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int res = INT_MIN;
        long long minProd = 1;
        long long maxProd = 1;

        for (int num : nums) {
            minProd *= num;
            maxProd *= num;
            res = max(res, (int)max(minProd, maxProd));
            if (num == 0) {
                minProd = 1;
                maxProd = 1;
            } else if (maxProd < 0) {
                maxProd = 1;
            }
        }
        minProd = 1;
        for (int i = (int)nums.size() - 1; i >= 0; i--) {
            minProd *= nums[i];
            res = max(res, (int)minProd);
            if (nums[i] == 0) minProd = 1;
        }

        return res;
    }
};
