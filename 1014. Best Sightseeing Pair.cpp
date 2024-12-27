class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        int maxPrev = values[0]; 
        int maxScore = INT_MIN;

        for (int j = 1; j < values.size(); j++) {
            maxScore = max(maxScore, maxPrev + values[j] - j);

            maxPrev = max(maxPrev, values[j] + j);
        }

        return maxScore;
    }
};