class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        auto cmp = [](const vector<int>& a, const vector<int>& b) {
            return (b[1] - b[0]) > (a[1] - a[0]);
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);

        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        int index = 0;
        vector<vector<int>> custQuery(queries.size(), vector<int>(2));
        for (int i = 0; i < (int)queries.size(); i++) {
            custQuery[i][0] = queries[i];
            custQuery[i][1] = i;
        }

        sort(custQuery.begin(), custQuery.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        vector<int> ans(queries.size());
        index = 0;

        for (auto& query : custQuery) {
            while (index < (int)intervals.size() && intervals[index][0] <= query[0]) {
                pq.push(intervals[index]);
                index++;
            }
            while (!pq.empty() && pq.top()[1] < query[0]) pq.pop();
            if (!pq.empty()) ans[query[1]] = pq.top()[1] - pq.top()[0] + 1;
            else ans[query[1]] = -1;
        }

        return ans;
    }
};

