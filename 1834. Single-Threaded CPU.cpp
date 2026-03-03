class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& nums) {
        auto cmp_pq = [](const vector<int>& a, const vector<int>& b) {
            return (a[1] != b[1]) ? (a[1] > b[1]) : (a[2] > b[2]);
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp_pq)> pq(cmp_pq);

        vector<vector<int>> tasks(nums.size(), vector<int>(3));
        for (int i = 0; i < (int)nums.size(); i++) {
            tasks[i][0] = nums[i][0];
            tasks[i][1] = nums[i][1];
            tasks[i][2] = i;
        }

        sort(tasks.begin(), tasks.end(), [](const vector<int>& a, const vector<int>& b) {
            return (a[0] != b[0]) ? (a[0] < b[0]) : (a[1] < b[1]);
        });

        long time = tasks[0][0];
        int index = 0;
        while (index < (int)tasks.size() && tasks[index][0] == time) {
            pq.push({tasks[index][0], tasks[index][1], tasks[index][2]});
            index++;
        }

        vector<int> ans(tasks.size());
        int ind = 0;
        while (!pq.empty()) {
            vector<int> topTask = pq.top();
            pq.pop();
            time += topTask[1];
            ans[ind++] = topTask[2];

            bool foundTask = false;
            while (index < (int)tasks.size() && tasks[index][0] <= time) {
                foundTask = true;
                pq.push({tasks[index][0], tasks[index][1], tasks[index][2]});
                index++;
            }
            if (!foundTask && index < (int)tasks.size() && pq.empty()) {
                time = tasks[index][0];
                pq.push({tasks[index][0], tasks[index][1], tasks[index][2]});
                index++;
            }
        }

        return ans;
    }
};