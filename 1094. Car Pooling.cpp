class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        sort(trips.begin(), trips.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[1] != b[1]) return a[1] < b[1];
            return a[2] < b[2];
        });

        int curr = 0;
        auto cmp = [](const vector<int>& a, const vector<int>& b) {
            return a[2] > b[2];
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> q(cmp);

        for (const auto& currTrip : trips) {
            while (!q.empty() && currTrip[1] >= q.top()[2]) {
                curr -= q.top()[0];
                q.pop();
            }
            q.push(currTrip);
            curr += currTrip[0];

            if (curr > capacity) return false;
        }

        return true;
    }
};