class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int ans = 0;
        int pastRow = -1;

        for (string& row : bank) {
            int currCount = 0;
            for (char c : row) {
                if (c == '1') currCount++;
            }

            if (currCount == 0) continue;
            if (pastRow != -1) ans += (pastRow * currCount);
            pastRow = currCount;
        }

        return ans;
    }
};
