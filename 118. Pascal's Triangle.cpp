class Solution {
public:
    vector<vector<int>> generate(int nr) {
        vector<vector<int>> arr;
        vector<int> temp;
        temp.push_back(1);
        arr.push_back(temp);

        if (nr == 1) return arr;
        temp.push_back(1);
        arr.push_back(temp);

        if (nr == 2) return arr;

        for (int i = 2; i < nr; i++) {
            vector<int> level;
            level.push_back(1);
            int left = 0, right = 1;
            int size = arr[i - 1].size();
            while (right < size) {
                level.push_back(arr[i - 1][left] + arr[i - 1][right]);
                left++;
                right++;
            }
            level.push_back(1);
            arr.push_back(level);
        }

        return arr;
    }
};
