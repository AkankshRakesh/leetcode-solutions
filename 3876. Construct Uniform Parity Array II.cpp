class Solution {
public:
    bool canOdd(vector<int>& nums, int odd) {
        for (int num : nums) {
            if (num % 2 == 0 && num < odd) return false;
        }

        return true;
    }

    bool uniformArray(vector<int>& nums1) {
        int smallestOdd = INT_MAX, smallestEven = INT_MAX;

        for (int num : nums1) {
            if (num % 2 != 0 && num < smallestOdd)
                smallestOdd = num;
            else if (num % 2 == 0 && num < smallestEven)
                smallestEven = num;
        }

        if (smallestOdd == INT_MAX || smallestEven == INT_MAX)
            return true;

        return canOdd(nums1, smallestOdd);
    }
};