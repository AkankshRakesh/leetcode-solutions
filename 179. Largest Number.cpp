class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> arr(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = to_string(nums[i]);
        }

        sort(arr.begin(), arr.end(), [](const string &a, const string &b) {
            return b + a < a + b; 
        });

        if (arr[0] == "0") return "0"; 

        string result;
        for (auto &s : arr) result += s;

        return result;
    }
};
