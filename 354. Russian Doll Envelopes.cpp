class Solution {
public:
    int maxEnvelopes(std::vector<std::vector<int>>& envelopes) {
        std::sort(envelopes.begin(), envelopes.end(), [](const std::vector<int>& a, const std::vector<int>& b) {
            if (a[0] != b[0]) return a[0] < b[0];
            return a[1] > b[1];
        });

        std::vector<std::vector<int>> arr;
        arr.push_back(envelopes[0]);
        for (size_t i = 1; i < envelopes.size(); i++) {
            if (arr.back()[0] < envelopes[i][0] && arr.back()[1] < envelopes[i][1]) {
                arr.push_back(envelopes[i]);
            } else {
                int left = 0;
                int right = arr.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid][0] >= envelopes[i][0] || arr[mid][1] >= envelopes[i][1]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left < (int)arr.size()) {
                    arr[left] = envelopes[i];
                }
            }
        }

        return arr.size();
    }
};

