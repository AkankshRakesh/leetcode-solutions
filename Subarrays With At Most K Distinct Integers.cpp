class Solution {
public:
    int countAtMostK(const std::vector<int>& arr, int k) {
        int count = 0;
        std::unordered_map<int, int> hm;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < (int)arr.size(); right++) {
            if (hm.find(arr[right]) != hm.end())
                hm[arr[right]]++;
            else {
                hm[arr[right]] = 1;
                count++;
            }

            while (count > k) {
                hm[arr[left]]--;
                if (hm[arr[left]] == 0) {
                    count--;
                    hm.erase(arr[left]);
                }
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
};

