class Solution {
public:
    int getTime(vector<int>& lst, vector<int>& ld, vector<int>& wst, vector<int>& wd) {
        int n = lst.size();
        int ind = 0;
        int leastTime = INT_MAX;

        // Find least finish time in first set
        for (int i = 0; i < n; i++) {
            if (lst[i] + ld[i] < leastTime) {
                ind = i;
                leastTime = lst[i] + ld[i];
            }
        }

        int m = wst.size();
        int ans = INT_MAX;

        // Find earliest finish in second set with possible buffer time
        for (int i = 0; i < m; i++) {
            int buffer = 0;
            if (leastTime < wst[i]) buffer = wst[i] - leastTime;

            ans = min(ans, buffer + wd[i]);
        }

        return leastTime + ans;
    }

    int earliestFinishTime(vector<int>& lst, vector<int>& ld, vector<int>& wst, vector<int>& wd) {
        return min(getTime(lst, ld, wst, wd), getTime(wst, wd, lst, ld));
    }
};
