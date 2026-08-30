class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int largest = 0;
        int smallest = 0;
        int n = nums.size();

        for (int i = 1; i < n; i++) {
            if (nums[largest] < nums[i]) largest = i;
            if (nums[smallest] > nums[i]) smallest = i;
        }

        if (largest == smallest)
            return min(largest + 1, n - largest);
        else if (largest < smallest)
            return min(smallest + 1, min(n - largest, largest + 1 + n - smallest));

        return min(largest + 1, min(n - smallest, smallest + 1 + n - largest));
    }
};