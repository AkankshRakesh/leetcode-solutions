class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        vector<int> start;
        vector<int> end;
        for(int i = 0; i < intervals.size(); i++){
            start.push_back(intervals[i][0]);
            end.push_back(intervals[i][1]);
        }
        sort(start.begin(), start.end());
        sort(end.begin(), end.end());
        int endptr = 0, ans = 0;
        for(int i = 0; i < start.size(); i++){
            if(start[i] > end[endptr]){
                endptr++;
            }
            else{
                ans++;
            }
        }
        return ans;
    }
};